package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Consultation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consultation_id_gen"
    )
    @SequenceGenerator(
            name = "consultation_id_gen",
            sequenceName = "consultation_id_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private LocalDate date;
    private String phoneNumber;
    private String courseType;
    @ManyToOne
    @JoinColumn(name = "office_ID")
    private Office office;


}
