package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class HashMapDemoApplicationTests {
    @Autowired
    private UserRepository repo;
    @Test
    void testContains() {
        User user = new User();
        Set<User> set = new HashSet<>();
        set.add(user);
        repo.save(user);
        Assert.isTrue(set.contains(user),"Entity not found in the set");
    }


}
