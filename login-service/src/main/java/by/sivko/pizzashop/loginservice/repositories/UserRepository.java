package by.sivko.pizzashop.loginservice.repositories;

import by.sivko.pizzashop.loginservice.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByActivationCode(String activationCode);
}
