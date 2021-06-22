package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public Monitor getById(int id) {
        Optional<Monitor> optional = monitorRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<Monitor> getAll() {
        return monitorRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        try {
            monitorRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean save(Monitor monitor) {
        return monitorRepository.save(monitor) != null;
    }

    @Override
    public boolean deleteAllByPlaceIsNull() {
        try {
            monitorRepository.deleteAllByPlaceIsNull();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
