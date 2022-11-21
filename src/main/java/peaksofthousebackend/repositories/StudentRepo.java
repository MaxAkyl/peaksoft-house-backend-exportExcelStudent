package peaksofthousebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksofthousebackend.dto.response.StudentResponse;
import peaksofthousebackend.models.Student;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query ("SELECT new peaksofthousebackend.dto.response.StudentResponse(" +
            "g.name, " +
            "g.lastName, " +
            "g.registerDate, " +
            "g.phoneNumber," +
            "g.dateOfBirth," +
            "g.email, " +
            "g.format, " +
            "g.extraPhoneNumber," +
            "g.banner," +
            "g.comment," +
            "g.isDownloaded)" +
            "from Student g order by g.registerDate desc ")
    List<StudentResponse> getAllStudents(Long id);

    @Query("SELECT s FROM Student s WHERE s.id in (?1)")
    List<Student> getAllStudentsByIds(List<Long> studentsId);
}
