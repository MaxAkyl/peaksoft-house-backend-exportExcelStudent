package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksofthousebackend.models.Office;

public interface OfficeRepo extends JpaRepository<Office, Long> {


}
