package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/")
    public List<Place> getAll(){
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable int id){
        return placeService.getById(id);
    }

    @PutMapping("/")
    public boolean save(@RequestBody Place place){
        return placeService.save(place);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        return placeService.deleteById(id);
    }
}
