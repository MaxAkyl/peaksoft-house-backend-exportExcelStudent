package peaksofthousebackend.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksofthousebackend.dto.request.BannerRequest;
import peaksofthousebackend.dto.response.BannerResponse;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.models.Banner;
import peaksofthousebackend.services.BannerService;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("api/banners")
@RequiredArgsConstructor
public class BannerApi {

    private final BannerService bannerService;

    @PostMapping()
    public SimpleResponse saveBanner(@RequestBody BannerRequest request) {
        return bannerService.saveBanner(request);
    }

    @GetMapping()
    public List<BannerResponse> getAllBanners() {
        return bannerService.getAllBanners();
    }

    @PutMapping("{id}")
    public Banner updateBanner(@RequestBody BannerRequest request, @PathVariable Long id) {
        return bannerService.updateBanner(id, request);
    }

    @GetMapping("{id}")
    public Banner getBanner(@PathVariable Long id) {
        return bannerService.getBanner(id);
    }

    @DeleteMapping("{id}")
    public SimpleResponse deleteBanner(@PathVariable Long id) {
        return bannerService.deleteById(id);
    }

}
