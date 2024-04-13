package org.lsh.controller;

import jakarta.annotation.Resource;
import org.lsh.entity.User;
import org.lsh.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList() {
        return userService.list();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.saveUserDetails(user);
    }
}
