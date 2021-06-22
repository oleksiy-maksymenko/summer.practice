package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.services.PcService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pc")
public class PcController {

    @Autowired
    PcService pcService;

    @GetMapping(value = "/")
    public List<PC> getAll() {
        return pcService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PC getById(@PathVariable int id) {
        return pcService.getById(id);
    }

    @PutMapping(value = "/")
    public boolean save(@RequestBody PC pc) {
        return pcService.save(pc);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteById(@PathVariable int id) {
        return pcService.deleteById(id);
    }
}
