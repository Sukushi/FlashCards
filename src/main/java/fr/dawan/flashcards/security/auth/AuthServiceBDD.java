package fr.dawan.flashcards.security.auth;

import fr.dawan.flashcards.business.user.*;
import fr.dawan.flashcards.security.tools.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceBDD implements AuthService {
    private final UserRepository repository;
	private final UserDetailsService userDetailsService;
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
		UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
        String token = JwtUtils.generateToken(userDetails);
        return new LoginResponseDto(mapper.toLoginDto((User) userDetails),token);
    }
}
