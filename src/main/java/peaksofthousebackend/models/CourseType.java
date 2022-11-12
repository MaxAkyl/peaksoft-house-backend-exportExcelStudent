package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "course_types")
@Getter
@Setter
public class CourseType {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_type_id_gen"
    )
    @SequenceGenerator(
            name = "course_type_id_gen",
            sequenceName = "course_type_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH})
    private Office office;

    @OneToMany(mappedBy = "type", cascade = ALL)
    private List<Banner> banners;
}
