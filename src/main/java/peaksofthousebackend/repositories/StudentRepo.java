package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksofthousebackend.models.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
