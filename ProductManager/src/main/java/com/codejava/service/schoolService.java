package com.codejava.service;

import com.codejava.dto.SchoolDTO;
import com.codejava.entity.School;
import com.codejava.mapper.SchoolMapper;
import com.codejava.projection.SchoolDetail;
import com.codejava.repository.schoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class schoolService {
    @Autowired
    private schoolRepository repo;
    @Autowired
    private SchoolMapper mapper;

    public List<SchoolDTO> getAll() {
        return repo.findAll().stream().map(school -> mapper.schoolToSchoolDTO(school)).collect(Collectors.toList());
    }

    public SchoolDTO getById(Long id) {
        return mapper.schoolToSchoolDTO(repo.findById(id).orElse(null));
    }

    public void save(SchoolDTO schoolDTO) {
        repo.save(mapper.schoolDTOToSchool(schoolDTO));
    }

    public void update(SchoolDTO schoolRequestDTO, Long id) {
        Optional<School> s = repo.findById(id);
        School schoolRequest = mapper.schoolDTOToSchool(schoolRequestDTO);
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

    public SchoolDetail findByAddress(String address) {
        return repo.findByAddress(address);
    }
}
