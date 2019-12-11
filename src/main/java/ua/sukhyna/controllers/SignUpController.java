package ua.sukhyna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.sukhyna.model.forms.UserForm;
import ua.sukhyna.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    public SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm){
        signUpService.signUp(userForm);
        return "redirect:/login";
    }
}
