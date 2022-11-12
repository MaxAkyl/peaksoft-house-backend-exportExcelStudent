package peaksofthousebackend.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveAdminRequest {

    private String email;
    private String password;
}
