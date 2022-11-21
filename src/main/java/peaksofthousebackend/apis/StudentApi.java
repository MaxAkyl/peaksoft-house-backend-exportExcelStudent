package peaksofthousebackend.apis;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksofthousebackend.dto.request.GetAllStudents;
import peaksofthousebackend.dto.request.StudentRequest;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.dto.response.StudentResponse;
import peaksofthousebackend.services.StudentService;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentApi {

    private final StudentService studentService;


    @PostMapping
    public SimpleResponse save(@RequestBody StudentRequest request,
                                @PathVariable Long id){
        return studentService.save(id, request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents (@PathVariable Long id){
        return studentService.getAllStudents(id);
    }

    @DeleteMapping("{id}")
    public SimpleResponse deleteStudent (@PathVariable("id") Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @PostMapping(
            value = "/get-excel-file",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<byte[]> exportExcel (@RequestBody GetAllStudents studentsId) throws IOException {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf("application/xlsx"));

        headers.set("Context-Disposition", "attachment; filename=\"students.xlsx\"");

        return new HttpEntity<>(studentService.studentsExportExcel(studentsId), headers);

    }
}
