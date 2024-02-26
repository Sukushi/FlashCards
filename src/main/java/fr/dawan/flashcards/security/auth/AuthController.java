package fr.dawan.flashcards.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
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
