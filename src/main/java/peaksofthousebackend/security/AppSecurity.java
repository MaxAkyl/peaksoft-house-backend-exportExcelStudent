package peaksofthousebackend.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
@RequiredArgsConstructor
public class AppSecurity {

    private final TokenFilter filter;

    @SneakyThrows
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) {
        http.cors().and().csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/swagger-ui/index.html", "/v3/api-docs/**", "/swagger").permitAll()
                        .anyRequest().permitAll()
                );

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
