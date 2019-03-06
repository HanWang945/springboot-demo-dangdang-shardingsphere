package com.test.demo.controller;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.test.demo.entity.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KeyGenerator keyGenerator;

    @PutMapping("/add")
    public User save(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return userRepository.save(new User(name, age));
    }

    @PutMapping("/add1")
    public User add1(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public void create() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(keyGenerator.generateKey().longValue(), "test" + i, i);
            userRepository.save(user);
        }
        for (int i = 10; i < 20; i++) {
            User user = new User(keyGenerator.generateKey().longValue(), "test" + i, i);
            userRepository.save(user);
        }


    }
}
