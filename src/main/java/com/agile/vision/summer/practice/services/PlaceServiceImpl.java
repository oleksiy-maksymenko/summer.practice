package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import com.agile.vision.summer.practice.repositories.PcRepository;
import com.agile.vision.summer.practice.repositories.WorkingPlaceRepository;
import com.agile.vision.summer.practice.services.exception.NonExistingIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final WorkingPlaceRepository workingPlaceRepository;

    @Autowired
    public PlaceServiceImpl(WorkingPlaceRepository workingPlaceRepository) {
        this.workingPlaceRepository = workingPlaceRepository;
    }

    @Override
    public Place getById(int id) {
        Optional<Place> optional = workingPlaceRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NonExistingIdException();
    }

    @Override
    public List<Place> getAll() {
        return workingPlaceRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        if (workingPlaceRepository.existsById(id)) throw new NonExistingIdException();
        workingPlaceRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean save(Place place) {
        return workingPlaceRepository.save(place) != null;
    }

    @Override
    public boolean deleteAllByPcNullOrMonitorsIsNull() {
        workingPlaceRepository.deleteAllByPcNullOrMonitorsIsNull();
        return true;
    }
}
