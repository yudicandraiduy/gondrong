package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.LocationRequest;
import com.iduy.gondrong.sevices.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
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
