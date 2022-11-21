package peaksofthousebackend.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksofthousebackend.enums.Format;
import peaksofthousebackend.models.Banner;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private LocalDateTime registerDate;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private LocalDate dateOfBirth;

    @NotBlank
    private String email;

    @NotBlank
    private Format format;

    private String extraPhoneNumber;

    private Banner banner;

    private String comment;
}
