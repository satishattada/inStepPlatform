package com.infy.InStepPlatform.controller;

import com.infy.InStepPlatform.dto.LoginDTO;
import com.infy.InStepPlatform.dto.UserDTO;
import com.infy.InStepPlatform.exception.DuplicateDataException;
import com.infy.InStepPlatform.exception.NotFoundException;
import com.infy.InStepPlatform.exception.UserRegistrationFailed;
import com.infy.InStepPlatform.service.UserService;
import jakarta.validation.Valid;
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
    UserService userService;

    @PostMapping(value="/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO userDTO) throws UserRegistrationFailed, DuplicateDataException {
        return new ResponseEntity<String>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping(value="/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) throws NotFoundException {
        return new ResponseEntity<String>(userService.login(loginDTO), HttpStatus.OK);
    }
}
