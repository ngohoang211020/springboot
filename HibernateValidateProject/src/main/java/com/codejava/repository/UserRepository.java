package com.codejava.repository;

import com.codejava.entity.User;
import com.codejava.projection.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.phone = ?1")
    UserDetail findByPhone(String phone);

}
