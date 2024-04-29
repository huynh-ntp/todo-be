package com.huynhntp.todobe.controller;

import com.huynhntp.todobe.configuration.jwt.JwtService;
import com.huynhntp.todobe.configuration.security.UserInfoService;
import com.huynhntp.todobe.dto.AccountDTO;
import com.huynhntp.todobe.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserInfoService userInfoService;
    private AccountService accountService;

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody AccountDTO accountDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDTO.getUsername(), accountDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(accountDTO.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.create(accountDTO), HttpStatus.CREATED);
    }

}
