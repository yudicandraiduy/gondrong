package com.iduy.gondrong.controller;

import com.iduy.gondrong.payload.request.CategoryRequest;
import com.iduy.gondrong.sevices.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity <?> addData (@Valid @RequestBody CategoryRequest category){
        service.addData(category);
        return ResponseEntity.ok("succes insert data");

    }
}
