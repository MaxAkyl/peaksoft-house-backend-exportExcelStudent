package peaksofthousebackend.models;


import peaksofthousebackend.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_id_gen"
    )
    @SequenceGenerator(
            name = "admin_id_gen",
            sequenceName = "admin_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
