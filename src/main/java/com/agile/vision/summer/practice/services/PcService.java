package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.PC;

import java.util.List;
import java.util.Optional;

public interface PcService {
    PC getById(int id);

    List<PC> getAll();

    boolean deleteById(int id);

    PC save(PC pc);

    boolean deleteAllByPlaceIsNull();

}
