package com.example.demo.sources.indigo;

import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.sources.AbstractSearchFactory;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Setter
@Slf4j
public class IndigoSearchFactory extends AbstractSearchFactory {

    @Override
    public SearchResult doSearch() {
        log.info("started indigo search with searchQuery : {}", getSearchQuery());
        IndigoSearchManager searchManager = IndigoSearchManager.builder().searchQuery(getSearchQuery()).build();
        log.info("finished indigo search with searchQuery : {}", getSearchQuery());
        return searchManager.doSearch();
    }
}
