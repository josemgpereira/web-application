package pt.jp.webapplication.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.jp.webapplication.entities.User;
import pt.jp.webapplication.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private List<String> getProfiles() {
        List<String> list = new ArrayList<>();
        list.add("Developer");
        list.add("Manager");
        list.add("Director");
        return list;
    }

    @GetMapping("/create-user")
    public String createUserView(Model model) {
        model.addAttribute("user", new User());
        //model.addAttribute("allProfiles", getProfiles());
        model.addAttribute("allProfiles", userService.getAllProfiles());
        return "user-creation";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.info("Validation errors while submitting form.");
            model.addAttribute("user", user);
            model.addAttribute("allProfiles", userService.getAllProfiles());
            return "user-creation";
        }
        userService.addUser(user);
        model.addAttribute("allUsers", userService.getAllUsers());
        logger.info("Form submitted successfully.");
        return "user-info";
    }
}