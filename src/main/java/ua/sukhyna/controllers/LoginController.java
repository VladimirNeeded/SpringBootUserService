package ua.sukhyna.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request){
        if (authentication!=null){
            return "redirect:/";
        }

        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }

        return "login";
    }
}