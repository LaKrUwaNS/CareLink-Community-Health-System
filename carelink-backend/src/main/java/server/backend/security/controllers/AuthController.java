package server.backend.security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;
import server.backend.dto.request.LoginRequestDTO;
import server.backend.dto.request.RegisterRequestDTO;
import server.backend.dto.response.AuthResponseDTO;
import server.backend.security.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // localhost:8080/api/auth/register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return "User registered successfully";
    }

    // localhost:8080/api/auth/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }


}