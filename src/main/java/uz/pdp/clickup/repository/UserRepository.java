package uz.pdp.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.clickup.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
}
