package com.mashup.srinee.user.controller;

import com.mashup.srinee.user.dto.UserDTO;
import com.mashup.srinee.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public UserDTO signUp(@RequestBody UserDTO userDTO) {
        return userService.signUp(userDTO);
    }
}
