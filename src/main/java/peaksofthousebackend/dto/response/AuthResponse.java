package peaksofthousebackend.dto.response;

import lombok.Builder;
import lombok.Data;
import peaksofthousebackend.enums.Role;

@Data
@Builder
public class AuthResponse {

    private Role role;
    private String token;

}
