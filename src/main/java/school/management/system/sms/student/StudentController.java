package school.management.system.sms.student;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

public class StudentController {
    private final StudentService studentService;


    @GetMapping("/all-students")
    public List getStudents(){
        System.out.println("fvdbcdbcdcdcdcdcd cabd cdbc dc hd cdah chd csh");
        return studentService.getAllStudents();
    }

    @PostMapping("/save-student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

}
