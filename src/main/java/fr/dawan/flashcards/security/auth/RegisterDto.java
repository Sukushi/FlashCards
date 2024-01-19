package fr.dawan.flashcards.security.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String username;
	private String password;
	private String email;
	private Role role = Role.USER;
}
