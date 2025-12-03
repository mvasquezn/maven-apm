package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<String, String> users = new HashMap<>();

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return users.getOrDefault(id, "User not found");
    }

    @PostMapping("/{id}")
    public String createUser(@PathVariable String id, @RequestBody String name) {
        users.put(id, name);
        return "User created";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody String name) {
        if (!users.containsKey(id)) {
            return "Cannot update — user does not exist";
        }
        users.put(id, name);
        return "User updated";
    }
}
