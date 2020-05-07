package pt.jp.webapplication.bootstrap;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.jp.webapplication.entities.Profile;
import pt.jp.webapplication.entities.User;
import pt.jp.webapplication.repositories.ProfileRepository;
import pt.jp.webapplication.repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Profile> profiles = new LinkedList<>();
        profiles.add(new Profile(1L, "Developer"));
        profiles.add(new Profile(2L, "Manager"));
        profiles.add(new Profile(3L, "Director"));
        profileRepository.saveAll(profiles);

        User user = new User();
        user.setUserName("josemgpereira");
        user.setGender("Male");
        user.setMarried(false);
        user.setProfile("Developer");
        userRepository.save(user);
        logger.info("Saved user with id " + user.getId());
    }
}