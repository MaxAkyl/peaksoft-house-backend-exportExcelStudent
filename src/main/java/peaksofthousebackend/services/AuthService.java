package peaksofthousebackend.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksofthousebackend.dto.request.AuthRequest;
import peaksofthousebackend.dto.response.AuthResponse;
import peaksofthousebackend.exceptions.InvalidPasswordException;
import peaksofthousebackend.exceptions.NotFoundException;
import peaksofthousebackend.models.Admin;
import peaksofthousebackend.repositories.AdminRepo;
import peaksofthousebackend.security.TokenUtility;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepo adminRepo;

    private final PasswordEncoder passwordEncoder;
    private final TokenUtility tokenUtility;

    public AuthResponse authentication(AuthRequest authRequest) {

        Admin admin = adminRepo.findByEmail(authRequest.email())
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь %s не найден", authRequest.email())));

        if (!passwordEncoder.matches(authRequest.password(), admin.getPassword())) {
            throw new InvalidPasswordException("Неверный пароль");
        }

        return AuthResponse.builder()
                .role(admin.getRole())
                .token(tokenUtility.generate(admin.getEmail())) // need to generate token
                .build();
    }
}
