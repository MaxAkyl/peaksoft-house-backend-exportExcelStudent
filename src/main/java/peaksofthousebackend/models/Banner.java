package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Banner {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "banner_id_gen"
    )
    @SequenceGenerator(
            name = "banner_id_gen",
            sequenceName = "banner_id_seq",
            allocationSize = 1
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "office_ID")
    private Office office;
    @ManyToOne
    @JoinColumn(name = "type_ID")
    private CourseType type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    List<Student> students;

}
