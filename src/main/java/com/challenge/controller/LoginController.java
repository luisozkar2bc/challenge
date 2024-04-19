package com.challenge.controller;

import com.challenge.security.AuthCredentials;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Login")
@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping
    public String login(@RequestBody AuthCredentials credential) {
        return "redirect:/login";
    }
}