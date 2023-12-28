package fr.dawan.flashcards.business.auth;

public interface AuthService {
    void register(RegisterDto dto);
    LoginResponseDto login(LoginDto dto) throws Exception;

}
