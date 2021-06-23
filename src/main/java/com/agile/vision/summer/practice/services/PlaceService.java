package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.Place;

import java.util.List;

public interface PlaceService {
    Place getById(int id);

    List<Place> getAll();

    boolean deleteById(int id);

    boolean save(Place place);

    boolean deleteAllByPcNullOrMonitorsIsNull();
}
