package com.mosees.springbootrestfulwebservices.Controller;

import com.mosees.springbootrestfulwebservices.Entity.User;
import com.mosees.springbootrestfulwebservices.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    // create user REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId) {
        User user = userService.getUserByID(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
