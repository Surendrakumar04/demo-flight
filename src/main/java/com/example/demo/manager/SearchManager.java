package com.example.demo.manager;

import com.example.demo.helper.SourceType;
import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.sources.AbstractSearchFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Slf4j
public class SearchManager {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);


    public SearchResult doSearch(SearchQuery searchQuery) {
        SearchResult searchResult = null;
        try {
            setApplicableSourceId(searchQuery);
           searchResult =  searchFromSources(searchQuery);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return searchResult;
    }

    /**
     * Searches for search results from multiple sources asynchronously.
     *
     * @param searchQuery the search query to be executed
     * @return the combined search result from all sources
     */
    private SearchResult searchFromSources(SearchQuery searchQuery) {
        List<Future<SearchResult>> futureTaskList = new ArrayList<>();
        SearchResult searchResult = null;
        for(Integer sourceId : searchQuery.getSourceIds()) {
            SourceType sourceType = SourceType.getSourceType(sourceId);
            Callable<SearchResult> task = () -> {
                AbstractSearchFactory searchFactory = sourceType.getFactoryInstance(searchQuery);
                return searchFactory.doSearch();  // Perform the search asynchronously
            };
            futureTaskList.add(executor.submit(task));
        }

        for(Future<SearchResult> futureTask : futureTaskList) {
            try {
                SearchResult result = futureTask.get();
                if(searchResult == null) {
                    searchResult = result;
                } else {
                    searchResult.getTripDetailsList().addAll(result.getTripDetailsList());
                }
            } catch (Exception e) {
                log.error("unable perform search for searchQuery : {}  with searchId : {} exception {}", searchResult.getSearchQuery(), searchResult.getSearchId(), e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /** This can be configured from backend .
     * let's say you want to restrict some sourceId , means you can't search from sourceId 1 (Indigo)
     * Or set only the sourceId that you want to search among all the sourced that you have integrated
     *
     */

    private void setApplicableSourceId(SearchQuery searchQuery) {
        searchQuery.setSourceIds(Arrays.asList(1, 2, 3));

    }
}
