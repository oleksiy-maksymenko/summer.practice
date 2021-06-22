package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PcServiceImpl implements PcService {

    private final PcRepository pcRepository;

    @Autowired
    public PcServiceImpl(PcRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    @Override
    public PC getById(int id) {
        Optional<PC> optional = pcRepository.getById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<PC> getAll() {
        return pcRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        try {
            pcRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean save(PC pc) {
        return pcRepository.save(pc) != null;
    }

    @Override
    public boolean deleteAllByPlaceIsNull() {
        try {
            pcRepository.deleteAllByPlaceIsNull();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
