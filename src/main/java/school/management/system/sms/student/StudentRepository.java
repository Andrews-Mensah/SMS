package school.management.system.sms.student;


import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student>findByEmail(String email);


    @Bean
    @Transactional
    @Modifying
    @Query(value = "UPDATE Student " +
            "SET enabled = TRUE WHERE email = ?1", nativeQuery = true)
    int enableStudent(String email);
}
