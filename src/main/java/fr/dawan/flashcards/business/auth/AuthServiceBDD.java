package fr.dawan.flashcards.business.auth;

import fr.dawan.flashcards.business.user.User;
import fr.dawan.flashcards.business.user.UserMapper;
import fr.dawan.flashcards.business.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceBDD implements AuthService {
    private UserRepository repository;
  /*  private final PasswordEncoder encoder;*/
    // Default DelegatingPasswordEncoder
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private UserMapper mapper;

    @Override
    public void register(RegisterDto dto) {
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User newUser = new User(dto.getUsername(),encodedPassword,dto.getEmail());
        repository.save(newUser);
    }

    @Override
    public LoginResponseDto login(LoginDto dto) throws Exception {
        User existingUser = repository.findByEmail(dto.getEmail()).orElse(null);
        if (existingUser == null) throw new BadCredentialsException("User not found");
        String encodedPassword = dto.getPassword();
        if (!encodedPassword.equals(existingUser.getPassword())) throw new BadCredentialsException("Invalid Password");
        String token = "token";
        return new LoginResponseDto(mapper.toDto(existingUser),token);
    }
}
