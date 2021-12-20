package com.codejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String phone;
    private Long schoolId;
    private String schoolName;
    private String schoolAddress;
}
