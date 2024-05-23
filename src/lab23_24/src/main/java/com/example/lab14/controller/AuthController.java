package com.example.lab14.controller;


import com.example.lab14.entity.JwtAuthenticationResponse;
import com.example.lab14.entity.SignInRequest;
import com.example.lab14.entity.SignUpRequest;
import com.example.lab14.service.AuthenticationService;
import com.example.lab14.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public String signUp(@RequestBody SignUpRequest request) {
            JwtAuthenticationResponse jwtResponse = authenticationService.signUp(request);
            return "registration complete";
    }


    @PostMapping("/login")
    public String signIn(@RequestBody SignInRequest request, HttpServletResponse response) {

            JwtAuthenticationResponse jwtResponse = authenticationService.signIn(request);
            Cookie jwtCookie = new Cookie("JWT", jwtResponse.getToken());
            jwtCookie.setHttpOnly(true);
            jwtCookie.setPath("/");
            jwtCookie.setMaxAge(24 * 60 * 60); // Для примера, 1 день
            response.addCookie(jwtCookie);
            return "login successful";
    }

    @GetMapping("/logout_m")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie jwtCookie = new Cookie("JWT", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(0);
        response.addCookie(jwtCookie);
        return "logged out";
    }
}