package com.example.demo.sources.spicejet;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.model.datamodel.SearchResult;
import com.example.demo.model.datamodel.SegmentDetails;
import com.example.demo.model.datamodel.TripDetails;
import lombok.Builder;

import java.util.Collections;

@Builder
public class SpiceJetSearchManager {
    private SearchQuery searchQuery;

    /** this method will call Indigo search ApI  with SpiceJetSearchRequest and
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
