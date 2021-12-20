package com.codejava.controller;

import com.codejava.dto.SchoolDTO;
import com.codejava.dto.StudentDTO;
import com.codejava.entity.Student;
import com.codejava.mapper.SchoolMapper;
import com.codejava.mapper.StudentMapper;
import com.codejava.service.schoolService;
import com.codejava.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    private schoolService schoolService;
    @Autowired
    private studentService studentService;

    @GetMapping("/schools")
    public ResponseEntity<List<SchoolDTO>> getListSchool() {
        List<SchoolDTO> list = schoolService.getAll().stream().map(school -> SchoolMapper.INSTANCE.schoolToSchoolDTO(school)).collect(Collectors.toList());
        if (!list.isEmpty()) {
            return new ResponseEntity<List<SchoolDTO>>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getListStudent() {
        List<StudentDTO> list = studentService.getAll().stream().map(student -> StudentMapper.INSTANCE.studentToStudentDTO(student)).collect(Collectors.toList());
        if (!list.isEmpty()) {
            return new ResponseEntity<List<StudentDTO>>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/schools")
    public ResponseEntity<?> createSchool(@RequestBody SchoolDTO schoolDTO) {
        try {
            schoolService.save(SchoolMapper.INSTANCE.schoolDTOToSchool(schoolDTO));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        Student s = StudentMapper.INSTANCE.studentDTOToStudent(studentDTO);
        try {
            studentService.save(s);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/schools/{id}")
    public ResponseEntity<?> updateSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable(name = "id") Long id) {
        try {
            schoolService.update(SchoolMapper.INSTANCE.schoolDTOToSchool(schoolDTO), id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable(name = "id") Long id) {
        try {
            studentService.update(StudentMapper.INSTANCE.studentDTOToStudent(studentDTO), id);
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
