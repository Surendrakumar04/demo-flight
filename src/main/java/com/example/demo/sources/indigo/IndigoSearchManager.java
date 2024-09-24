package com.example.demo.sources.indigo;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.model.datamodel.SegmentDetails;
import com.example.demo.model.datamodel.TripDetails;
import lombok.Builder;

import java.util.Collections;

@Builder
public class IndigoSearchManager {

    private SearchQuery searchQuery;

    /** this method will call Indigo search ApI by with indigoSearchRequest and
     * will parse the received response to our SearchResult model
    * */
    public SearchResult doSearch() {
        TripDetails tripDetails = new TripDetails();
        SegmentDetails segmentDetails = new SegmentDetails();
        segmentDetails.setSourceId("DEL");
        segmentDetails.setDestinationId("BOM");
        tripDetails.setSegmentDetailsList(Collections.singletonList(segmentDetails));
        return SearchResult.builder().searchId("1111").searchQuery(searchQuery).tripDetailsList(Collections.singletonList(tripDetails)).build();
    }
}
