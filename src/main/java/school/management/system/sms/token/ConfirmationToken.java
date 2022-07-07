package school.management.system.sms.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.management.system.sms.student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "confirmationtoken")
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
            name = "confirmation_sequence",
            sequenceName = "confirmation_sequence"
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confirmation_sequence")
    @Column
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false, name = "createdTime")
    private LocalDateTime createdTime;

    @Column(nullable = false, name = "expiredTime")
    private LocalDateTime expiredTime;

    @Column(name = "confirmedTime")
    private LocalDateTime confirmedTime;

    @ManyToOne
    @JoinColumn(name = "student_id",
            nullable = false)
    Student student;

    public ConfirmationToken(String token,
                             LocalDateTime createdTime,
                             LocalDateTime expiredTime,
                             Student student){
        this.token = token;
        this.createdTime = createdTime;
        this.expiredTime = expiredTime;
        this.student = student;

    }
}
