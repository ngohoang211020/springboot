package com.codejava.projection;

public interface StudentDetail {
    String getStudentName();
    String getPhone();
    infoSchool getSchool();
    interface infoSchool{
        String getSchoolName();
        String getAddress();
    }
}
