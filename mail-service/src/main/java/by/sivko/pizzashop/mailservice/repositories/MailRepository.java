package by.sivko.pizzashop.mailservice.repositories;

import by.sivko.pizzashop.mailservice.entities.EMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<EMail, Long> {
}
