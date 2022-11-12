package peaksofthousebackend.apis;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksofthousebackend.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "auth-api")
@CrossOrigin
@RequiredArgsConstructor
public class AuthApi {

    // login
    private final AuthService authService;

}
