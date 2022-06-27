package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.CompanyRequest;
import com.iduy.gondrong.sevices.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity <?> addData(@Valid @RequestBody CompanyRequest request){
        service.addData (request);
        return ResponseEntity.ok("sukses insert data");

    }



}
