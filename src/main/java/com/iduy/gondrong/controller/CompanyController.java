package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.request.CompanyRequest;
import com.iduy.gondrong.sevices.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> aadData(@Valid @RequestBody CompanyRequest request){
        logger.info("Entering addData method on class " + CompanyController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addData(request);
        logger.info("Leaving addData method on class " + CategoryController.class.getName() + " at " + System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<CommonResponse> getAllData(){
        logger.info("Entering addData method on class" + CompanyController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.allDataCompanies();
        logger.info("Leaving getAllData method on class" + CompanyController.class.getName() + " at " + System.currentTimeMillis());
        return  new ResponseEntity<>(response,HttpStatus.OK);


    }




}
