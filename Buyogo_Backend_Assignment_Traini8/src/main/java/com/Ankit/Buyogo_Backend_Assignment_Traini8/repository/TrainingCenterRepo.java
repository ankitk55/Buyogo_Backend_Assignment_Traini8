package com.Ankit.Buyogo_Backend_Assignment_Traini8.repository;

import com.Ankit.Buyogo_Backend_Assignment_Traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingCenterRepo extends JpaRepository<TrainingCenter,Long> {

    Optional<TrainingCenter> findByContactPhone(String centerContactPhone);

    Optional<TrainingCenter> findByCenterName(String centerName);
}
