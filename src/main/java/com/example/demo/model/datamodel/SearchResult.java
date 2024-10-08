package com.example.demo.model.datamodel;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class SearchResult {
    private String searchId;
    private SearchQuery searchQuery;
    private List<TripDetails> tripDetailsList;

    public List<TripDetails> getTripDetailsList() {
        if(tripDetailsList == null) {
           this.tripDetailsList = new ArrayList<>();
        }
        return tripDetailsList;
    }
}
