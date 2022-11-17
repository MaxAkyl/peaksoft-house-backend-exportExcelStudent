package peaksofthousebackend.apis;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksofthousebackend.dto.request.StudentRequest;
import peaksofthousebackend.dto.response.SimpleResponse;
import peaksofthousebackend.services.StudentService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentApi {

    private final StudentService studentService;


    // get all students by banner id
    @GetMapping
    public SimpleResponse save(@RequestBody StudentRequest request,
                                @PathVariable Long id){
        return studentService.save(id, request);
    }
    // delete students by student's ids
    // export students
}
