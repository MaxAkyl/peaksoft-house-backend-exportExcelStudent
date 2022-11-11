package entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Banner {

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
