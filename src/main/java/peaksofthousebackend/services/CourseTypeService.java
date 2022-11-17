package peaksofthousebackend.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksofthousebackend.repositories.CourseTypeRepo;

@Service
@RequiredArgsConstructor
public class CourseTypeService {

    private final CourseTypeRepo courseTypeRepo;


}
