package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.Monitor;

import java.util.List;

public interface MonitorService {
    Monitor getById(int id);

    List<Monitor> getAll();

    boolean deleteById(int id);

    boolean save(Monitor monitor);

    boolean deleteAllByPlaceIsNull();
}
