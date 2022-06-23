package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.EventRequest;
import com.iduy.gondrong.sevices.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService service;


    public EventController(EventService service) {
        this.service = service;}

    @PostMapping
    public ResponseEntity<?> addData (@Valid @RequestBody EventRequest event){
        service.addData(event);
        return ResponseEntity.ok("sukses cuy");



    }

}
