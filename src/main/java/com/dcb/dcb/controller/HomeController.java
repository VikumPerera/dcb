package com.dcb.dcb.controller;

import com.dcb.dcb.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello Spring World";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Vikum");
        user.setEmail("vikumchathuranga92@gmail.com");
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        user.setName("Vikum");
        user.setEmail("vikumchathuranga92@gmail.com");
        return user;
    }

    @GetMapping("/user/email")
    public User getUserByEmail(@RequestParam String email) {
        User user = new User();
        user.setId("1");
        user.setName("Vikum");
        user.setEmail(email);
        return user;
    }

}
