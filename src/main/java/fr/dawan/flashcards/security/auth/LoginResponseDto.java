package fr.dawan.flashcards.security.auth;

import fr.dawan.flashcards.business.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private UserDto user;
    private String token;
}
