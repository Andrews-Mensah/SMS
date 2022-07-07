package school.management.system.sms.student;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class StudentRegistrationController {


    private StudentRegistrationService registrationService;

    public String register (@RequestBody StudentRegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }
}
