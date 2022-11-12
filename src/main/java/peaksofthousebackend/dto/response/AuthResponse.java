package peaksofthousebackend.dto.response;

import lombok.Data;
import peaksofthousebackend.enums.Role;

@Data
public class AuthResponse {

    private Role role;
    private String token;

}
