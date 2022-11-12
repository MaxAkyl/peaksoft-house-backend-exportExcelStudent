package peaksofthousebackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "banners")
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

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH})
    private Office office;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH})
    private CourseType type;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @OneToMany(mappedBy = "banner", cascade = ALL)
    private List<Student> students;
}
