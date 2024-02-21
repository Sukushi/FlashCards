package fr.dawan.flashcards.security.auth;

import fr.dawan.flashcards.business.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String username;
	private String password;
	private String email;
}
