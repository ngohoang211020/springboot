package com.codejava.controller;

import com.codejava.entity.Product;
import com.codejava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class Controller {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getPageProduct(@RequestParam("page") Integer page
            ,@RequestParam("size")Integer size,@RequestParam("sortBy")String sortBy) {
        try {
            return new ResponseEntity<Page<Product>>(service.getProductWithPage(page,size,sortBy), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/products")
    public ResponseEntity<?> create100Products() {
        try {
            service.save100Product();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
