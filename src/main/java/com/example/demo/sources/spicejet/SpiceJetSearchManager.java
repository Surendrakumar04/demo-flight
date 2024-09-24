package com.example.demo.sources.spicejet;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import lombok.Builder;

@Builder
public class SpiceJetSearchManager {
    private SearchQuery searchQuery;

    /** this method will call Indigo search ApI  with SpiceJetSearchRequest and
     * will parse the received response to our SearchResult model
     * */
    public SearchResult doSearch() {
        return null;
    }
}
