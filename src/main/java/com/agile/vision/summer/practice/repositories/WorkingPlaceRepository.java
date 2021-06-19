package com.agile.vision.summer.practice.repositories;


import com.agile.vision.summer.practice.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkingPlaceRepository extends JpaRepository<Place, Integer> {
    Optional<Place> findById(int id);

    void deleteAllByPcNullOrMonitorsIsNull();
}
