package be.technobel.fbrassine.repository;

import be.technobel.fbrassine.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByPasswordAndEmail(String password, String email);
    User findByPasswordAndEmail(String password, String email);
}
