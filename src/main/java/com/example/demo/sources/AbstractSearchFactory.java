package com.example.demo.sources;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import lombok.Data;


public abstract class AbstractSearchFactory {
    private SearchQuery searchQuery;

    public AbstractSearchFactory() {
    }

    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }

    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    public abstract SearchResult doSearch();
}
