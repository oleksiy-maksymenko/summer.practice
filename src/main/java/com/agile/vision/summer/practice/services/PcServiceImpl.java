package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.repositories.PcRepository;
import com.agile.vision.summer.practice.services.exception.NonExistingIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PcServiceImpl implements PcService {

    @Autowired
    private PcRepository pcRepository;

    @Override
    public PC getById(int id) {
        Optional<PC> optional = pcRepository.getById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NonExistingIdException();
    }

    @Override
    public List<PC> getAll() {
        return pcRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        if (pcRepository.existsById(id)) throw new NonExistingIdException();
        pcRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean save(PC pc) {
        return pcRepository.save(pc) != null;
    }

    @Override
    public boolean deleteAllByPlaceIsNull() {
        pcRepository.deleteAllByPlaceIsNull();
        return true;
    }
}
