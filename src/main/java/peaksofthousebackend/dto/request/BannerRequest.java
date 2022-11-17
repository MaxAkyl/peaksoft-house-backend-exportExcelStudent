package peaksofthousebackend.dto.request;


import lombok.Getter;
import lombok.Setter;
import peaksofthousebackend.models.CourseType;
import peaksofthousebackend.models.Office;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class BannerRequest {

    @NotNull(message = "Надо выбрать офис")
    private Office office;

    @NotNull(message = "Надо выбрать один из курсов")
    private CourseType type;

    @Future
    private LocalDateTime startDateTime;

    @Future
    private LocalDateTime endDateTime;

}
