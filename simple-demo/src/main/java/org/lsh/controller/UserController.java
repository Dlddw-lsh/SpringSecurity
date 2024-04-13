package org.lsh.controller;

import jakarta.annotation.Resource;
import org.lsh.common.Result;
import org.lsh.entity.User;
import org.lsh.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public List<User> getList() {
        return userService.list();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public void addUser(@RequestBody User user) {
        userService.saveUserDetails(user);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        return userService.login(user);
    }
}
