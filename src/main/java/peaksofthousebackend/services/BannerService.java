package peaksofthousebackend.services;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import peaksofthousebackend.dto.request.BannerRequest;
import peaksofthousebackend.dto.response.BannerResponse;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.exceptions.InvalidDateException;
import peaksofthousebackend.models.Banner;
import peaksofthousebackend.models.CourseType;
import peaksofthousebackend.models.Office;
import peaksofthousebackend.repositories.BannerRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class BannerService {

    private final BannerRepo bannerRepo;

    public SimpleResponse saveBanner(BannerRequest bannerRequest) {

        Banner banner = new Banner();
        Office office = bannerRequest.getOffice();
        CourseType courseType = bannerRequest.getType();
        banner.setOffice(office);
        banner.setType(courseType);
        LocalDateTime startDateTime = bannerRequest.getStartDateTime();
        LocalDateTime endDateTime = bannerRequest.getEndDateTime();
        if (startDateTime.isAfter(endDateTime)) {
            throw new InvalidDateException(
                    "Дата начало не может быть после конца даты"
            );
        }
        return new SimpleResponse(
                "OK",
                "Баннер создан успешно!"
        );
    }

    public List<BannerResponse> getAllBanners() {
        return bannerRepo.getAllBanners();
    }

    @Transactional
    public Banner updateBanner(Long bannerId, BannerRequest bannerRequest) {
        Banner banner = bannerRepo.findById(bannerId).orElseThrow(() ->
                new NotFoundException("Баннер с " + bannerId + "-id не найден!"));
        CourseType type = bannerRequest.getType();
        if (!banner.getType().equals(bannerRequest.getType())) {
            banner.setType(bannerRequest.getType());
        }
        Office office = bannerRequest.getOffice();
        if (!banner.getOffice().equals(bannerRequest.getOffice())) {
            banner.setOffice(bannerRequest.getOffice());
        }
        if (bannerRequest.getStartDateTime().isAfter(bannerRequest.getEndDateTime())) {
            throw new InvalidDateException("Дата начала не может быть после даты окончания");
        }
        banner.setStartDateTime(bannerRequest.getStartDateTime());
        banner.setEndDateTime(bannerRequest.getEndDateTime());
        return banner;
    }

    public Banner getBanner(Long id) {
        return bannerRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Баннер с " + id + " -id не найден!"));
    }

    public SimpleResponse deleteById(Long bannerId) {
        if (!bannerRepo.existsById(bannerId)) {
            throw new NotFoundException("Баннер с " + bannerId + "-id не найден!");
        }
        bannerRepo.deleteById(bannerId);
        return new SimpleResponse("OK", bannerId + "-id yспешно удалён!");
    }

}
