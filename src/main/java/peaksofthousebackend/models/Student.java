package peaksofthousebackend.models;

import peaksofthousebackend.enums.Format;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_gen"
    )
    @SequenceGenerator(
            name = "student_id_gen",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String lastName;

    private LocalDateTime registerDate;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String email;

    @Enumerated(EnumType.STRING)
    private Format format;

    private String extraPhoneNumber;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH})

    private Banner banner;

    private Boolean isDownloaded;


    public Student() {
    }

    public Student(String name, String lastName, LocalDateTime registerDate,
                   String phoneNumber, LocalDate dateOfBirth, String email,
                   Format format, String extraPhoneNumber, Banner banner, Boolean isDownloaded) {
        this.name = name;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.format = format;
        this.extraPhoneNumber = extraPhoneNumber;
        this.banner = banner;
        this.isDownloaded = false;
    }

    public Student(String name, String lastName, LocalDateTime now, String phoneNumber, LocalDate dateOfBirth, String email, Format format, String extraPhoneNumber, Banner orElseThrow) {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registerDate=" + registerDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", format=" + format +
                ", extraPhoneNumber='" + extraPhoneNumber + '\'' +
                ", banner=" + banner +
                ", isDownloaded=" + isDownloaded +
                '}';
    }
}
