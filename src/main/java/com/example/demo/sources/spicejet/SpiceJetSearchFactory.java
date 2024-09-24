package com.example.demo.sources.spicejet;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.sources.AbstractSearchFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpiceJetSearchFactory extends AbstractSearchFactory {
    @Override
    public SearchResult doSearch() {
        log.info("started spiceJet search with searchQuery : {}", getSearchQuery());
        SpiceJetSearchManager searchManager = SpiceJetSearchManager.builder().searchQuery(getSearchQuery()).build();
        log.info("finished spiceJet search with searchQuery : {}", getSearchQuery());
        return searchManager.doSearch();
    }
}
