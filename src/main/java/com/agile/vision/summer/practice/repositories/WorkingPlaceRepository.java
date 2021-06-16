package com.agile.vision.summer.practice.repositories;


import com.agile.vision.summer.practice.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingPlaceRepository extends JpaRepository<Place, Integer> {

}
