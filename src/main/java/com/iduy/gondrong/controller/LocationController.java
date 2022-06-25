package com.iduy.gondrong.controller;

import com.iduy.gondrong.models.Location;
import com.iduy.gondrong.models.LocationService;
import com.iduy.gondrong.payload.request.LocationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity <?> addData(@Valid @RequestBody LocationRequest request){
        service.addData (request);
        return ResponseEntity.ok("sukses insert data");
    }
}