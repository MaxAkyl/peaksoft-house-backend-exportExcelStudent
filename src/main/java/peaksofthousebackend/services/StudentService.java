package peaksofthousebackend.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksofthousebackend.dto.request.GetAllStudents;
import peaksofthousebackend.dto.request.StudentRequest;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.dto.response.StudentResponse;
import peaksofthousebackend.exceptions.NotFoundException;
import peaksofthousebackend.models.Banner;
import peaksofthousebackend.models.Student;
import peaksofthousebackend.repositories.BannerRepo;
import peaksofthousebackend.repositories.CourseTypeRepo;
import peaksofthousebackend.repositories.StudentRepo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final BannerRepo bannerRepo;
    private final CourseTypeRepo typeRepo;
    private final StudentRequest studentRequest;
    private final ExcelWriterService excelWriterService;

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
                        )),
                request.getComment()

        );

        banner.setStudent(student);
        student.setBanner(banner);
        studentRepo.save(student);
        return new SimpleResponse("Created", "Successfully saved new student!");
    }

    public List<StudentResponse> getAllStudents(Long bannerId) {
        return studentRepo.getAllStudents(bannerId);
    }

    public SimpleResponse deleteStudent(Long studentRequest) {
        if(!studentRepo.existsById(studentRequest)){
            throw new NotFoundException(
                    "Student with id: " + studentRequest + " not found"
            );
        }
        studentRepo.deleteById(studentRequest);
        return new SimpleResponse("OK", "Successfully deleted student!");
    }

    @Transactional
    public byte[] studentsExportExcel(GetAllStudents studentsId) throws IOException{

        List<Student> students = studentRepo.getAllStudentsByIds(studentsId.getStudentsId());

        Workbook sheets = excelWriterService.getExcelFile(students);

        for (Student student: students) {
            student.setIsDownloaded(true);}
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        sheets.write(stream);

        return stream.toByteArray();
    }
}
