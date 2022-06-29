package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.request.LocationRequest;
import com.iduy.gondrong.sevices.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
public class LocationController {

    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity <CommonResponse> addData(@Valid @RequestBody LocationRequest request){
        logger.info("Entering addData method on class" + LocationController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addData(request);
        logger.info("Leaving addData method on class" + LocationController.class.getName() + " at " + System.currentTimeMillis(),response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllData(){
        logger.info("Entering getAllData method on class" + LocationController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.allDataLocations();
        logger.info(" Leaving getAllData method on class" + LocationController.class.getName() + " at " + System.currentTimeMillis(),response);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
