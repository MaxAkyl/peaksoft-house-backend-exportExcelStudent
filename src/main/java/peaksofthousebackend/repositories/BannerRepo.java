package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksofthousebackend.dto.response.BannerResponse;
import peaksofthousebackend.models.Banner;

import java.util.List;

public interface BannerRepo extends JpaRepository<Banner, Long> {

    @Query("SELECT new peaksofthousebackend.dto.response.BannerResponse(" +
            "b.id," +
            "b.office," +
            "b.type," +
            "b.startDateTime," +
            "b.endDateTime)" +
            "FROM Banner b ORDER BY b.id DESC ")
    List<BannerResponse> getAllBanners();

}
