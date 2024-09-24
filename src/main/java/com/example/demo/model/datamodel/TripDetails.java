package com.example.demo.model.datamodel;

import lombok.Data;

import java.util.List;

@Data
public class TripDetails {
    private List<SegmentDetails> segmentDetailsList;
}
