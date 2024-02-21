package fr.dawan.flashcards.security.auth;

import fr.dawan.flashcards.business.user.Role;
import fr.dawan.flashcards.business.user.User;
import fr.dawan.flashcards.business.user.UserMapper;
import fr.dawan.flashcards.business.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceBDD implements AuthService {
    private final UserRepository repository;
	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;

    @Override
    public void register(RegisterDto dto) {
        String encodedPassword = encoder.encode(dto.getPassword());
        User newUser = new User(dto.getUsername(),encodedPassword,dto.getEmail(), List.of(Role.USER));
        repository.save(newUser);
    }

    @Override
    public LoginResponseDto login(LoginDto dto) throws Exception {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword(), new ArrayList<>()));
        User existingUser = repository.findByEmail(dto.getEmail()).orElse(null);
        String token = "token";
        return new LoginResponseDto(mapper.toDto(existingUser),token);
    }
}
