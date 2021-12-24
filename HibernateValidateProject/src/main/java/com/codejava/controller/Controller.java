package com.codejava.controller;

import com.codejava.entity.User;
import com.codejava.projection.UserDetail;
import com.codejava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getListUser() {
        try {

            return new ResponseEntity<List<User>>(service.getList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<UserDetail> findUserByPhone(@RequestParam(value = "phone") String phone) {
        try {

            return new ResponseEntity<UserDetail>(service.findUserByPhone(phone), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        try {
            service.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
