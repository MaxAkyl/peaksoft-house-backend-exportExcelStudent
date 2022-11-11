package repositories;

import entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository <Banner, Long>  {


}
