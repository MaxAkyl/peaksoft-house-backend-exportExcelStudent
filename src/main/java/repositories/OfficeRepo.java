package repositories;

import entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepo extends JpaRepository <Office, Long> {


}
