package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.request.EventRequest;
import com.iduy.gondrong.sevices.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
public class EventController {


    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;}

    @PostMapping
    public ResponseEntity<CommonResponse> addData (@Valid @RequestBody EventRequest request){
        logger.info("Entering addData method on class"+ EventController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addData(request);
        logger.info("Leaving addData method on class" + EventController.class.getName() + " at " + System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<CommonResponse> getAllData(){
        logger.info("Entering addData method on class"+ EventController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.allDataEvents();
        logger.info("Leaving addData method on class"+ EventController.class.getName() + " at " + System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
