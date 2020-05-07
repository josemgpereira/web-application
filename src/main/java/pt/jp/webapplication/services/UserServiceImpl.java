package pt.jp.webapplication.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.jp.webapplication.entities.Profile;
import pt.jp.webapplication.entities.User;
import pt.jp.webapplication.repositories.ProfileRepository;
import pt.jp.webapplication.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //private List<User> allUsers = new ArrayList<>();
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    @Override
    public List<User> getAllUsers() {
        //return allUsers;
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        //allUsers.add(user);
        userRepository.save(user);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}