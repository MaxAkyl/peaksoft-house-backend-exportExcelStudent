package peaksofthousebackend.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import peaksofthousebackend.exceptions.NotFoundException;
import peaksofthousebackend.models.Admin;
import peaksofthousebackend.repositories.AdminRepo;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

    private final TokenUtility tokenUtility;
    private final AdminRepo adminRepo;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {

        getToken(request).ifPresent((token) -> {
            String email = null;
            try {
                email = tokenUtility.verify(token);
            } catch (Exception e) {
                try {
                    response.sendError(403, e.getMessage());
                } catch (IOException ex) {}
                return;
            }

            Admin admin = adminRepo.findByEmail(email)
                    .orElseThrow(() -> new NotFoundException("not found"));

            UserDetailsImpl userDetails = new UserDetailsImpl(admin);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);
        });

        filterChain.doFilter(request, response);
    }

    private Optional<String> getToken(HttpServletRequest request) {

        String requestHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(requestHeader)) {
            return Optional.of(requestHeader);
        }
        return Optional.empty();
    }
}
