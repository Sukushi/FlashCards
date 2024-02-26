package fr.dawan.flashcards.security.auth;

import fr.dawan.flashcards.business.user.UserLoginDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private UserLoginDto user;
    private String token;
}
