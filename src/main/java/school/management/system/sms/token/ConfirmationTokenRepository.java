package school.management.system.sms.token;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken (String token);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ConfirmationToken " +
            "SET confirmed_time = ?2 " +
            "WHERE token = ?1", nativeQuery = true)
    int updateconfirmedTime(String token,
                          LocalDateTime confirmed_time);
}
