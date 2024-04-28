package com.Ankit.Buyogo_Backend_Assignment_Traini8.service;

import com.Ankit.Buyogo_Backend_Assignment_Traini8.model.TrainingCenter;
import com.Ankit.Buyogo_Backend_Assignment_Traini8.repository.TrainingCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepo trainingCenterRepo;
    public ResponseEntity<TrainingCenter> saveNewTrainingCenter(TrainingCenter trainingCenter) {
        // Set Current Date Time for Training_Center Creation
        trainingCenter.setCreatedOn(LocalDateTime.now());
       TrainingCenter newTrainingCenter = trainingCenterRepo.save(trainingCenter);
        return new ResponseEntity<>(newTrainingCenter, HttpStatus.CREATED);

    }

    public ResponseEntity<List<TrainingCenter>> getAllRegisteredTrainingCenters() {
        List<TrainingCenter>trainingCentersList =trainingCenterRepo.findAll();
        return ResponseEntity.ok(trainingCentersList);
    }

    public Optional<TrainingCenter> findByContactPhone(String centerContactPhone) {
        return trainingCenterRepo.findByContactPhone(centerContactPhone);
    }

    public Optional<TrainingCenter> findByCenterName(String centerName) {
        return trainingCenterRepo.findByCenterName(centerName);
    }
}
