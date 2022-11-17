package peaksofthousebackend.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksofthousebackend.dto.request.StudentRequest;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.exceptions.NotFoundException;
import peaksofthousebackend.models.Banner;
import peaksofthousebackend.models.Student;
import peaksofthousebackend.repositories.BannerRepo;
import peaksofthousebackend.repositories.CourseTypeRepo;
import peaksofthousebackend.repositories.StudentRepo;

import java.time.LocalDateTime;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final BannerRepo bannerRepo;
    private final CourseTypeRepo typeRepo;

    @Transactional
    public SimpleResponse save (Long id, StudentRequest request) {

        Banner banner = bannerRepo.findById(id).orElseThrow(() -> new NotFoundException("Banner with id: " + id + " couldn't find!"));

        Student student = null;

        student = new Student(
                request.getName(),
                request.getLastName(),
                LocalDateTime.now(),
                request.getPhoneNumber(),
                request.getDateOfBirth(),
                request.getEmail(),
                request.getFormat(),
                request.getExtraPhoneNumber(),
                bannerRepo.findById(id)
                        .orElseThrow(()-> new NotFoundException(
                                "Cannot found banner with id " + id
                        ))
        );

        banner.setStudents(List <Student> students);
        student.setBanner(banner);
        studentRepo.save(student);
        return new SimpleResponse("Created", "Successfully saved new student!");
    }

}
