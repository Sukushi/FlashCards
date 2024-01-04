package fr.dawan.flashcards.business.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("register")
    void register(RegisterDto registerDto) {
        service.register(registerDto);
    }
    @PostMapping("login")
    LoginResponseDto login(@RequestBody LoginDto loginDto) throws Exception {
        return service.login(loginDto);
    }
}
