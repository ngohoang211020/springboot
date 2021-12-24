package com.codejava.controller;

import com.codejava.entity.Address;
import com.codejava.entity.Person;
import com.codejava.repository.AddressRepository;
import com.codejava.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {
    @Autowired
    private PersonRepository personRepo;
    @Autowired
    private AddressRepository addressRepo;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getListPerson() {
        try {

            return new ResponseEntity<List<Person>>(personRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getListAddress() {
        try {
            return new ResponseEntity<List<Address>>(addressRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/person")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<?> saveUser(@RequestBody Person person) {
        try {
            personRepo.save(person);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/address")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<?> saveAddress(@RequestBody Address address) {
        try {
            addressRepo.save(address);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/address/{id}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<?> deleteAdress(@PathVariable("id") Long id) {
        try {
            addressRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/person/{id}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        try {
            personRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
