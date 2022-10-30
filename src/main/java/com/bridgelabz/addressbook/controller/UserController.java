package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.entity.User;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody User user){
        return new ResponseEntity<>(userService.userLogin(user), HttpStatus.OK);
    }

}
