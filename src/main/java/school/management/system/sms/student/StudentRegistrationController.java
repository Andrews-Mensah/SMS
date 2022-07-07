package school.management.system.sms.student;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class StudentRegistrationController {


    private StudentRegistrationService registrationService;


    @PostMapping("/registration")
    public String register (@RequestBody StudentRegistrationRequest registrationRequest){
//        System.out.println("gvshshvshvsxvssagvasgvasgvasgsa");
        return registrationService.register(registrationRequest);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
