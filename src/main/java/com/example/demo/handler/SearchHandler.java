package com.example.demo.handler;

import com.example.demo.base.ServiceHandler;
import com.example.demo.manager.SearchManager;
import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.model.restmodel.AirSearchRequest;
import com.example.demo.model.restmodel.AirSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchHandler extends ServiceHandler<AirSearchRequest, AirSearchResponse> {

    @Autowired
    SearchManager searchManager;
    @Override
    public void beforeProcess() throws Exception {
        // some extra information can be populated in request before performing the search
    }

    @Override
    public void process() throws Exception {
        SearchResult searchResult = null;
        if (request.getSearchQuery() != null) {
            searchResult = searchManager.doSearch(request.getSearchQuery());
        }
        response.setSearchId(request.getSearchId());
        response.setSearchResult(searchResult);

    }

    @Override
    public void afterProcess() throws Exception {

        // further processing if required like the same trip you may receive from different sources
        // So you can not show the duplicate trip to the user in the UI, before showing the final result
        // to the user you must filter out the duplicate trips with some logic or on condition

    }
}
