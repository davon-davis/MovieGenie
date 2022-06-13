package davon.davis.moviegenie.repositories;


import davon.davis.moviegenie.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
