package com.codejava.service;

import com.codejava.entity.User;
import com.codejava.projection.UserDetail;
import com.codejava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> getList() {
        return repo.findAll();
    }

    public UserDetail findUserByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    public void save(User user) {
        repo.save(user);
    }
}
