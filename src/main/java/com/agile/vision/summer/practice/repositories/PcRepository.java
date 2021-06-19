package com.agile.vision.summer.practice.repositories;


import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PcRepository extends JpaRepository<PC, Integer> {
    void deleteAllByPlaceIsNull();

    Optional<PC> getById(int id);
}
