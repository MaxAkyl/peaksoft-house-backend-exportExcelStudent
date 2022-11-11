package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Office {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "office_id_gen"
    )
    @SequenceGenerator(
            name = "office_id_gen",
            sequenceName = "office_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private List<CourseType> courseType;

    private List<Banner> banners;

    private List<Consultation> consultations;
}
