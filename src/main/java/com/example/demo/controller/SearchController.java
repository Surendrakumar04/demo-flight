package com.example.demo.controller;

import com.example.demo.handler.SearchHandler;
import com.example.demo.model.restmodel.AirSearchRequest;
import com.example.demo.model.restmodel.AirSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo-service")
@RestController
@Slf4j
public class SearchController {


    @Autowired
    SearchHandler searchHandler;

    @RequestMapping(value = "/air-search", method = RequestMethod.POST)
    protected AirSearchResponse search(@RequestBody AirSearchRequest searchRequest) throws Exception {
        searchHandler.initData(searchRequest, new AirSearchResponse());
        return searchHandler.getResponse();
    }
}
