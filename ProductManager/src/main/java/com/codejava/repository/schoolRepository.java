package com.codejava.repository;

import com.codejava.entity.School;
import com.codejava.projection.SchoolDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface schoolRepository extends JpaRepository<School,Long> {
    @Query("select s from School s where s.address = ?1")
    SchoolDetail findByAddress(String address);

}
