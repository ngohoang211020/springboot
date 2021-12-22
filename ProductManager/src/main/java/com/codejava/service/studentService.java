package com.codejava.service;

import com.codejava.dto.StudentDTO;
import com.codejava.dto.StudentINFO;
import com.codejava.entity.Student;
import com.codejava.mapper.StudentMapper;
import com.codejava.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentService {
    @Autowired
    private studentRepository repo;
    @Autowired
    private StudentMapper mapper;

    public List<StudentINFO> getAll() {
        return repo.findAll().stream().map(student -> mapper.studenToStudentINFO(student)).collect(Collectors.toList());

    }

    public StudentDTO getById(Long id) {
        return mapper.studentToStudentDTO(repo.findById(id).orElse(null));
    }

    public void save(StudentDTO studentDTO) {
        repo.save(mapper.studentDTOToStudent(studentDTO));
    }

    public void update(StudentDTO studentDTO, Long id) {
        Student studentRequest = mapper.studentDTOToStudent(studentDTO);
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
