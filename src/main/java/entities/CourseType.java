package entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CourseType {

    private String name;
    @ManyToOne
    @JoinColumn(name = "office_ID")
    private Office office;


}
