package entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter @Setter
public class Office {

    private String name;
    List<CourseType> courseType;
    List<Banner> banners;
    List<Consultation> consultations;

}
