package fr.dawan.flashcards.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final AuthService service;

    @PostMapping("register")
    void register(@RequestBody RegisterDto registerDto) {
        service.register(registerDto);
    }
    @PostMapping("login")
    LoginResponseDto login(@RequestBody LoginDto loginDto) throws Exception {
        return service.login(loginDto);
    }
}
