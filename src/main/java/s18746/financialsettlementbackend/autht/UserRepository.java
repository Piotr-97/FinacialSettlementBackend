package s18746.financialsettlementbackend.autht;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByUuid(String uuid);
}
