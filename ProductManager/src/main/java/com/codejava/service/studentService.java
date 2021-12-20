package com.codejava.service;

import com.codejava.entity.Student;
import com.codejava.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    private studentRepository repo;

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).get();
    }

    public void save(Student student) {
        repo.save(student);
    }

    public void update(Student studentRequest, Long id) {
        Student student = repo.findById(id).orElse(null);
        if (student != null) {
            student.setStudentName(studentRequest.getStudentName());
            student.setPhone(studentRequest.getPhone());
            student.setSchool(studentRequest.getSchool());
            repo.save(student);
        }
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
