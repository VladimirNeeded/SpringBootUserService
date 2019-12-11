package ua.sukhyna.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.sukhyna.security.details.UserDetailsImpl;
import ua.sukhyna.transfer.UserDto;


@Controller
public class ProfileController {

    @GetMapping("/")
    public String getProfilePage(Authentication authentication, ModelMap model){

        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto userDto = UserDto.from(details.getUser());
        model.addAttribute("user", userDto);
        return "profile";
    }
}
