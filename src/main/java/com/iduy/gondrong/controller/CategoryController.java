package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.request.CategoryRequest;
import com.iduy.gondrong.sevices.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addData(@Valid @RequestBody CategoryRequest category){
        logger.info("Entering addData method on class " + CategoryController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addData(category);
        logger.info("Leaving addData method on class " + CategoryController.class.getName() + " at " + System.currentTimeMillis(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllData() {
        logger.info("Entering getAllData method on class " + CategoryController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.allDataCategories();
        logger.info("Leaving getAllData method on class " + CategoryController.class.getName() + " at " + System.currentTimeMillis(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
