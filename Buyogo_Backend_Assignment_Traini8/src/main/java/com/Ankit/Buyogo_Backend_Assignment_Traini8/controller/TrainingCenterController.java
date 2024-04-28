package com.Ankit.Buyogo_Backend_Assignment_Traini8.controller;

import com.Ankit.Buyogo_Backend_Assignment_Traini8.exceptions.DuplicateCenterPhoneNumberException;
import com.Ankit.Buyogo_Backend_Assignment_Traini8.model.TrainingCenter;
import com.Ankit.Buyogo_Backend_Assignment_Traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    // API for register new Training_Center
@PostMapping("/trainingcenter")
    public ResponseEntity<TrainingCenter>saveNewTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
    // Getting center_Name for checking Training_Center already present or not with this Name.
    String centerName =trainingCenter.getCenterName();
    // Search training_center by  center_name using Custom_finder
    Optional<TrainingCenter> findByCenterName =trainingCenterService.findByCenterName(centerName);
    // Checking Training_Center is present or not , if present than throw a custom Exception, Duplicate Center_Name can't be accepted
    if(findByCenterName.isPresent()){
        throw new DuplicateCenterPhoneNumberException("Center_Name : '"+centerName+"' already registered ..");
    }

    //  Getting center_phone for checking Training_Center already present or not with this Phone.
    String centerContactPhone =trainingCenter.getContactPhone();
    // Search training_center by  contact_phone using Custom_finder
    Optional<TrainingCenter> findByContactPhone =trainingCenterService.findByContactPhone(centerContactPhone);
    // Checking Training_Center is present or not , if present than throw a custom Exception ,Duplicate Phone_Number can't be accepted
    if(findByContactPhone.isPresent()){
        throw new DuplicateCenterPhoneNumberException("Center_Phone_Number : '"+centerContactPhone+"' already registered ..");
    }

    // save new Training_center into DataBase
        return trainingCenterService.saveNewTrainingCenter(trainingCenter);
    }


    // API for fetching a List of ALL registered Training_Centers
    @GetMapping("/trainingcenters")
    public ResponseEntity<List<TrainingCenter>>getAllRegisteredTrainingCenters(){
    return trainingCenterService.getAllRegisteredTrainingCenters();
    }
}
