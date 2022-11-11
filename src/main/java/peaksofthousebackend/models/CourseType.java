package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    private Office office;
}
