package com.codejava.mapper;

import com.codejava.dto.SchoolDTO;
import com.codejava.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    SchoolDTO schoolToSchoolDTO(School school);

    School schoolDTOToSchool(SchoolDTO schoolDTO);

}
