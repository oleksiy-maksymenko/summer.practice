package com.agile.vision.summer.practice.repositories;

import com.agile.vision.summer.practice.entities.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MonitorRepository extends JpaRepository<Monitor, Integer> {

}
