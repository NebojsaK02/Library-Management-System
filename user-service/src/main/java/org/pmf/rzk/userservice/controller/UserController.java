package org.pmf.rzk.userservice.controller;

import jakarta.validation.Valid;
import org.pmf.rzk.userservice.model.User;
import org.pmf.rzk.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
