package pt.jp.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.jp.webapplication.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}