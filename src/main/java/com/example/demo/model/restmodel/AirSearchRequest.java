package com.example.demo.model.restmodel;

import com.example.demo.model.datamodel.SearchQuery;
import lombok.Data;

@Data
public class AirSearchRequest {
    private String searchId;
    private SearchQuery searchQuery;
}
