package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.services.MonitorService;
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

    @GetMapping(value ="/")
    public ResponseEntity<List<Monitor>> getAll() {
        return new ResponseEntity<>(monitorService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Monitor> getById(@PathVariable int id) {
        return new ResponseEntity<>(monitorService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value ="/")
    public ResponseEntity<Boolean> save(@RequestBody Monitor monitor) {
        if (monitorService.save(monitor)) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        if (monitorService.deleteById(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

}
