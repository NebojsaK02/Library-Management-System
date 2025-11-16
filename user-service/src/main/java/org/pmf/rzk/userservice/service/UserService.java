package org.pmf.rzk.userservice.service;

import org.pmf.rzk.userservice.model.User;
import org.pmf.rzk.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username vec postoji");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email vec postoji");
        }
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User nije pronadjen"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Pogresna sifra");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
