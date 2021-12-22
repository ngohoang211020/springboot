package com.codejava.mapper;

import com.codejava.dto.SchoolDTO;
import com.codejava.entity.School;
import com.codejava.service.schoolService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = schoolService.class, componentModel = "spring")
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    SchoolDTO schoolToSchoolDTO(School school);

    School schoolDTOToSchool(SchoolDTO schoolDTO);

}
