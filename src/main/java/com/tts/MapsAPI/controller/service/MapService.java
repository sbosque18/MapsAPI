package com.tts.MapsAPI.controller.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.MapsAPI.model.GeoCodingResponse;
import com.tts.MapsAPI.model.Location;

@Service
public class MapService {

    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates (Location location){
//        URL from root geocoding to get info about city,state
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                location.getCity() + "," + location.getState() + "&key=" + apiKey;
//        Make API call to google maps and store that info as a response in
        System.out.println("key is " + apiKey);
        RestTemplate restTemplate = new RestTemplate();
        GeoCodingResponse response = restTemplate.getForObject(url, GeoCodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }
}
