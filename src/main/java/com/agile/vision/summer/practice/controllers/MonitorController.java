package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.services.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/monitor")
public class MonitorController {

    @Autowired
    MonitorService monitorService;

    @GetMapping("/")
    public List<Monitor> getAll(){
        return monitorService.getAll();
    }

    @GetMapping("/{id}")
    public Monitor getById(@PathVariable int id){
        return monitorService.getById(id);
    }

    @PutMapping("/")
    public boolean save(@RequestBody Monitor monitor){
        return monitorService.save(monitor);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        return monitorService.deleteById(id);
    }

}
