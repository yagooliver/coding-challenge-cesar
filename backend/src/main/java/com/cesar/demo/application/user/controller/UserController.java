package com.cesar.demo.application.user.controller;

import com.cesar.demo.application.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository _userRepository;

    @GetMapping("/user")
    public OAuth2User getCurrentUser() {
        System.out.println("Hello world");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((OAuth2AuthenticationToken)auth).getPrincipal();
    }
}
