package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.EventRequest;
import com.iduy.gondrong.sevices.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
@CrossOrigin(origins = "*")
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
