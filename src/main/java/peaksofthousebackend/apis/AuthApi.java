package peaksofthousebackend.apis;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksofthousebackend.dto.request.AuthRequest;
import peaksofthousebackend.dto.response.AuthResponse;
import peaksofthousebackend.services.AuthService;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "auth-api")
@CrossOrigin
@RequiredArgsConstructor
public class AuthApi {
    // login
    private final AuthService authService;

    @PostMapping("/authenticate")
    @PermitAll
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest){
        return authService.authentication(authRequest);
    }
}
