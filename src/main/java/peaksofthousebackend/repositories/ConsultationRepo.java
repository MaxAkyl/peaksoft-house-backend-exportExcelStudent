package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksofthousebackend.models.Consultation;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {


}
