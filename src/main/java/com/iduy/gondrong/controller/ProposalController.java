package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.ProposalRequest;
import com.iduy.gondrong.sevices.ProposalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {

    private final ProposalService service;

    public ProposalController(ProposalService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> addData (@Valid @RequestBody ProposalRequest proposal){
        service.addData(proposal);
        return ResponseEntity.ok("mantap cees");

    }
}
