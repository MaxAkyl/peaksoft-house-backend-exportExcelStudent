package entities;

import enums.Format;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private LocalDate registerDate;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String email;
    private Format format;
    private String extraPhoneNumber;
    @ManyToOne
    @JoinColumn(name = "banner_ID")
    private Banner banner;
}
