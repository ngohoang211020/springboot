package com.codejava.controller;

import com.codejava.dto.SchoolDTO;
import com.codejava.dto.StudentDTO;
import com.codejava.dto.StudentINFO;
import com.codejava.service.schoolService;
import com.codejava.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    private schoolService schoolService;
    @Autowired
    private studentService studentService;

    @GetMapping("/schools")
    public ResponseEntity<List<SchoolDTO>> getListSchool() {
        try {
            return new ResponseEntity<List<SchoolDTO>>(schoolService.getAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentINFO>> getListStudent() {
        try {
            return new ResponseEntity<List<StudentINFO>>(studentService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/schools")
    public ResponseEntity<?> createSchool(@RequestBody SchoolDTO schoolDTO) {
        try {
            schoolService.save(schoolDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        try {
            studentService.save(studentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/schools/{id}")
    public ResponseEntity<?> updateSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable(name = "id") Long id) {
        try {
            schoolService.update(schoolDTO, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable(name = "id") Long id) {
        try {
            studentService.update(studentDTO, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable(name = "id") Long id) {
        try {
            schoolService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id) {
        try {
            studentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
