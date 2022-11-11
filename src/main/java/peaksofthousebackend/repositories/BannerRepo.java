package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksofthousebackend.models.Banner;

public interface BannerRepo extends JpaRepository<Banner, Long> {

}
