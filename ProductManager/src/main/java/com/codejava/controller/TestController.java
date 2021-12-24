package com.codejava.controller;

import com.codejava.projection.SchoolDetail;
import com.codejava.projection.StudentDetail;
import com.codejava.service.schoolService;
import com.codejava.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class TestController {
    @Autowired
    private schoolService schoolService;
    @Autowired
    private studentService studentService;

    @GetMapping("/school")
    public ResponseEntity<SchoolDetail> getSchoolByAddress(@RequestParam(name = "address") String address) {
        try {
            return new ResponseEntity<SchoolDetail>(schoolService.findByAddress(address), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/student")
    public ResponseEntity<StudentDetail> getStudentByPhone(@RequestParam(name = "phone") String phone) {
        try {
            return new ResponseEntity<StudentDetail>(studentService.findByPhone(phone), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
