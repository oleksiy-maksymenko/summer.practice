package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.MonitorService;
import com.agile.vision.summer.practice.services.PlaceService;
import com.agile.vision.summer.practice.services.exception.NonExistingIdException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/monitor")
public class MonitorController {

    @Autowired
    MonitorService monitorService;
    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Monitor>> getAll() {
        return new ResponseEntity<>(monitorService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Monitor> getById(@PathVariable int id) {
        Monitor monitor;
        monitor = monitorService.getById(id);
        return new ResponseEntity<>(monitor, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Boolean> save(@RequestAttribute Integer id, @RequestAttribute String createdAt, @RequestAttribute String createdBy,
                                        @RequestAttribute String updatedBy, @RequestAttribute String updatedAt, @RequestAttribute double length,
                                        @RequestAttribute double height, @RequestAttribute double width, @RequestAttribute double displaySize,
                                        @RequestAttribute int place_id) {

        Monitor monitor;
        if (place_id != 0) {
            Place place = placeService.getById(place_id);
            monitor = Monitor.builder().id(id).height(height).createdBy(createdBy).createdAt(createdAt)
                    .length(length).updatedAt(updatedAt).updatedBy(updatedBy).width(width).displaySize(displaySize)
                    .displaySize(displaySize).place(place).build();
        } else {
            monitor = Monitor.builder().id(id).height(height).createdBy(createdBy).createdAt(createdAt)
                    .length(length).updatedAt(updatedAt).updatedBy(updatedBy).width(width).displaySize(displaySize)
                    .displaySize(displaySize).build();
        }

        if (monitorService.save(monitor)!=null) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        if (monitorService.deleteById(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
