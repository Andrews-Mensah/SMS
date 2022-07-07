package school.management.system.sms.student;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import school.management.system.sms.token.ConfirmationToken;
import school.management.system.sms.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@Component
@AllArgsConstructor
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    public String studentSignUp(Student student){
        Optional<Student> studentExist = studentRepository.findByEmail(student.getEmail());

        if(studentExist.isPresent()){
            throw new IllegalStateException("Student already exists");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(student.getPassword());

        System.out.println("hchcvcvagcvagcvacggcgcasgcvsagvsag" + encodedPassword);
        student.setPassword(encodedPassword);

        studentRepository.save(student);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                student
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public int enableStudent(String email) {
        return studentRepository.enableStudent(email);
    }
}
