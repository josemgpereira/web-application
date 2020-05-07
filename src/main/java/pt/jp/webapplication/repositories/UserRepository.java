package pt.jp.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.jp.webapplication.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}