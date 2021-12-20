package com.codejava.service;

import com.codejava.entity.School;
import com.codejava.repository.schoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class schoolService {
    @Autowired
    private schoolRepository repo;

    public List<School> getAll() {
        return repo.findAll();
    }

    public School getById(Long id) {
        return repo.findById(id).get();
    }

    public void save(School school) {
        repo.save(school);
    }

    public void update(School schoolRequest, Long id) {
        Optional<School> s = repo.findById(id);
        if (s.isPresent()) {
            School school = s.orElse(null);
            school.setSchoolName(schoolRequest.getSchoolName());
            school.setAddress(schoolRequest.getAddress());
            if (schoolRequest.getStudentList() != null) {
                school.setStudentList(schoolRequest.getStudentList());
            }
            repo.save(school);
        }
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
