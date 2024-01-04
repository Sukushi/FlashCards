package fr.dawan.flashcards.business.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String password;
    private String email;

    public String getEmail() {
    }

    public String getPassword() {
    }
}
