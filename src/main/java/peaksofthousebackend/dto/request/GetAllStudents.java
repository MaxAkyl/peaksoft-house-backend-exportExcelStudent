package peaksofthousebackend.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllStudents {
    private List<Long> studentsId;
}
