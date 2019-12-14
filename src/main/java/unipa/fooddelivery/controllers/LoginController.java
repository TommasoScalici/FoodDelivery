package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login/")
    public String getLoginView() {
        return "login";
    }

    @RequestMapping(value = "/register/")
    public String getRegisterView() {
        return "register";
    }
}