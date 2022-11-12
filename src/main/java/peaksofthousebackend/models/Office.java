package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "offices")
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

    @OneToMany(mappedBy = "office", cascade = ALL)
    private List<CourseType> courseType;

    @OneToMany(mappedBy = "office", cascade = {MERGE, REMOVE, REFRESH, DETACH})
    private List<Banner> banners;

    @OneToMany(mappedBy = "office")
    private List<Consultation> consultations;
}
