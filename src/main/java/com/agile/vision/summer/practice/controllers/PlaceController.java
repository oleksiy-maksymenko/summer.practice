package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/")
    public List<Place> getAll() {
        return placeService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Place getById(@PathVariable int id) {
        return placeService.getById(id);
    }

    @PutMapping(value = "/")
    public boolean save(@RequestBody Place place) {
        return placeService.save(place);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteById(@PathVariable int id) {
        return placeService.deleteById(id);
    }
}
