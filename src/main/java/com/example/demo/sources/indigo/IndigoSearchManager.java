package com.example.demo.sources.indigo;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import lombok.Builder;

@Builder
public class IndigoSearchManager {

    private SearchQuery searchQuery;

    /** this method will call Indigo search ApI by with indigoSearchRequest and
     * will parse the received response to our SearchResult model
    * */
    public SearchResult doSearch() {
        return null;
    }
}
