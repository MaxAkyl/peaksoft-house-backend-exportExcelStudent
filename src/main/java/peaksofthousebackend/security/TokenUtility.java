package peaksofthousebackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class TokenUtility {

    @Value("${app.security.jwt.secret}")
    private String secret;

    @Value("${app.security.jwt.expiresAfterDays}")
    private int expiresAfterDays;

    // token generator
    public String generate(String email) {
        return JWT.create()
                .withClaim("email", email)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(ZonedDateTime.now().plusDays(expiresAfterDays).toInstant()))
                .sign(Algorithm.HMAC512(secret));
    }

    // token verifier
    public String verify(String token) {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret)).build();

        DecodedJWT decodedJWT = verifier.verify(token);

        return decodedJWT.getClaim("email").asString();
    }
}
