package com.codejava.repository;

import com.codejava.entity.Student;
import com.codejava.projection.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.phone = ?1")
    StudentDetail findByPhone(String phone);
}
