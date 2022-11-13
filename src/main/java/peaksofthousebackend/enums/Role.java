package peaksofthousebackend.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN_BISHKEK,
    ADMIN_MOSCOW;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
