package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.PcService;

import java.util.List;

import com.agile.vision.summer.practice.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/pc")
public class PcController {

    @Autowired
    PcService pcService;
    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/")
    public ResponseEntity<List<PC>> getAll() {
        return new ResponseEntity<>(pcService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PC> getById(@PathVariable int id) {
        return new ResponseEntity<>(pcService.getById(id),HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Boolean> save(@RequestAttribute Integer id, @RequestAttribute String createdAt, @RequestAttribute String createdBy,
                                        @RequestAttribute String updatedBy, @RequestAttribute String updatedAt, @RequestAttribute double width,
                                        @RequestAttribute double height, @RequestAttribute double length, @RequestAttribute int cpuCount, @RequestAttribute int hddSize,
                                        @RequestAttribute int place_id) {
        PC pc;
        if (place_id != 0) {
            Place place = placeService.getById(place_id);
            pc = PC.builder().id(id).createdAt(createdAt).createdBy(createdBy).cpuCount(cpuCount).hddSize(hddSize).height(height)
                    .length(length).updatedAt(updatedAt).updatedBy(updatedBy).width(width).place(place).build();
        } else {
            pc = PC.builder().id(id).createdAt(createdAt).createdBy(createdBy).cpuCount(cpuCount).hddSize(hddSize).height(height)
                    .length(length).updatedAt(updatedAt).updatedBy(updatedBy).width(width).build();
        }

        if (pcService.save(pc) != null) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        if (pcService.deleteById(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
