package be.technobel.fbrassine.repository;

import be.technobel.fbrassine.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByUserLogin(String userLogin);
    boolean existsByPasswordAndUserLogin(String password, String userLogin);
    User findByPasswordAndUserLogin(String password, String userLogin);
}
