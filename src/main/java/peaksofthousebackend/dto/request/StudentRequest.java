package peaksofthousebackend.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksofthousebackend.enums.Format;
import peaksofthousebackend.models.Banner;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private LocalDate registerDate;

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
}
