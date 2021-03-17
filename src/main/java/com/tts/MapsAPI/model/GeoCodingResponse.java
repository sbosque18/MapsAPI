package com.tts.MapsAPI.model;

import java.util.List;

import lombok.Data;

@Data
public class GeoCodingResponse {
    private List<Geocoding> results;
}
