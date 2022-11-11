package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksofthousebackend.models.CourseType;

public interface CourseTypeRepo extends JpaRepository<CourseType, Long> {

}
