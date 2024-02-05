package com.dcb.dcb.controller;

import com.dcb.dcb.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello Spring World";
    }

    @GetMapping("/user")
    public UserDTO user() {
        UserDTO user = new UserDTO();
        user.setId("1");
        user.setName("Vikum");
        user.setEmail("vikumchathuranga92@gmail.com");
        return user;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("Vikum");
        user.setEmail("vikumchathuranga92@gmail.com");
        return user;
    }

    @GetMapping("/user/email")
    public UserDTO getUserByEmail(@RequestParam String email) {
        UserDTO user = new UserDTO();
        user.setId("1");
        user.setName("Vikum");
        user.setEmail(email);
        return user;
    }

}
