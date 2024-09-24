package com.example.demo.model.restmodel;

import com.example.demo.base.BaseResponse;
import com.example.demo.model.datamodel.SearchResult;
import lombok.Data;

@Data
public class AirSearchResponse extends BaseResponse {
    private SearchResult searchResult;
    private String searchId;
}
