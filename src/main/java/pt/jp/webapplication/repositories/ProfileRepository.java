package pt.jp.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jp.webapplication.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}