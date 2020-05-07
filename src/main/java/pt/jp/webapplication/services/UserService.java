package pt.jp.webapplication.services;

import pt.jp.webapplication.entities.Profile;
import pt.jp.webapplication.entities.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    List<Profile> getAllProfiles();
}