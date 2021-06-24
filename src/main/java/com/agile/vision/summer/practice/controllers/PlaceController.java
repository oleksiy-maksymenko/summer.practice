package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/")
    public  ResponseEntity<List<Place>> getAll() {
        return new  ResponseEntity<>(placeService.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Place> getById(@PathVariable int id) {
        return new ResponseEntity<>(placeService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Place> save(@RequestBody Place place) {
        Place placeSaved = placeService.save(place);
        if (placeService.save(place) != null) {
            return new ResponseEntity<>(placeSaved, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        if (placeService.deleteById(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
