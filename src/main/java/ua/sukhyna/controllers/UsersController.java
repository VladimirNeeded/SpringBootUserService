package ua.sukhyna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.sukhyna.repository.UserRepository;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(ModelMap model){
        model.addAttribute("usersFromServer", userRepository.findAll());
        return "users";
    }
}
