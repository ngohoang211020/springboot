package com.codejava.mapper;

import com.codejava.dto.StudentDTO;
import com.codejava.dto.StudentINFO;
import com.codejava.entity.Student;
import com.codejava.service.studentService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = studentService.class,componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentToStudentDTO(Student student);

    Student studentDTOToStudent(StudentDTO studentDTO);

    StudentINFO studenToStudentINFO(Student student);
}
