package com.tts.MapsAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.MapsAPI.model.Location;
import com.tts.MapsAPI.controller.service.MapService;

@Controller
public class MapsController {

    @Autowired
    private MapService mapService;

    @GetMapping("/")
    public String getDefaultMap(Model model){
        model.addAttribute(new Location());
        return "index";
    }
        @PostMapping("/home")
        public String getMapForLocation(Location location, Model model) {
            mapService.addCoordinates(location);
            model.addAttribute(location);
            return "index";
    }
}
