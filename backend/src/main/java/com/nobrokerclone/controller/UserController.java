package com.nobrokerclone.controller;

import com.nobrokerclone.entity.AppUser;
import com.nobrokerclone.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<AppUser> list() {
        return userRepository.findAll();
    }
}
