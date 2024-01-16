package fr.dawan.flashcards.security.auth;

public interface AuthService {
    void register(RegisterDto dto);
    LoginResponseDto login(LoginDto dto) throws Exception;

}
