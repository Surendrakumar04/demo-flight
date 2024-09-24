package com.example.demo.model.datamodel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
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
