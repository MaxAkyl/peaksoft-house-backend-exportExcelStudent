package peaksofthousebackend.dto.response;

import lombok.Getter;
import lombok.Setter;
import peaksofthousebackend.models.CourseType;
import peaksofthousebackend.models.Office;

import java.time.LocalDateTime;

@Getter
@Setter
public class BannerResponse {

    private Long bannerId;
    private Office office;
    private CourseType type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public BannerResponse(Long bannerId, Office office, CourseType type, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.bannerId = bannerId;
        this.office = office;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
