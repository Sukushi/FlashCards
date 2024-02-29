package fr.dawan.flashcards.business.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
	private long id;
	private String name;
	private List<Role> roles;
}
