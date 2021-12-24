package com.codejava.mapper;

import com.codejava.dto.SchoolDTO;
import com.codejava.entity.School;
import com.codejava.service.schoolService;
import org.mapstruct.Mapper;


@Mapper(uses = schoolService.class, componentModel = "spring")
public interface SchoolMapper {

    SchoolDTO schoolToSchoolDTO(School school);

    School schoolDTOToSchool(SchoolDTO schoolDTO);

}
