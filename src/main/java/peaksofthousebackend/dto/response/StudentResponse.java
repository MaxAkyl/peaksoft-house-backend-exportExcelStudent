package peaksofthousebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksofthousebackend.enums.Format;
import peaksofthousebackend.models.Banner;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {

    private String name;
    private String lastName;
    private LocalDateTime registerDate;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String email;
    private Format format;
    private String extraPhoneNumber;
    private Banner banner;
    private Boolean isDownloaded;

}
