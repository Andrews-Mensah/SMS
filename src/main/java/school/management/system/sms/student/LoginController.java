package school.management.system.sms.student;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class LoginController {

    private final StudentService studentService;

//    @PostMapping("/login")
//    public String login (@RequestBody Student student){
//        Student auth = studentService.login(student.getUsername(), student.getPassword());
//
//        return "hhvbnmnx mx x xxx";
//    }
}
