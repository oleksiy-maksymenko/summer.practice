package com.agile.vision.summer.practice.repositories;

import com.agile.vision.summer.practice.entities.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
    Optional<Monitor> findById(int id);

    void deleteAllByPlaceIsNull();
}
