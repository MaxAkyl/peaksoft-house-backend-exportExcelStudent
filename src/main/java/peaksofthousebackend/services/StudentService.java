package peaksofthousebackend.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import peaksofthousebackend.repositories.StudentRepo;

@Service
@Getter
@Setter
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
}
