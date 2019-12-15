package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login")
    public String getLoginView() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String getRegisterView() {
        return "register";
    }

    @RequestMapping(value = {"/login/result"})
    public @ResponseBody String getLoginResultView(@RequestParam(value="username") final String username, 
                                                   @RequestParam(value="password") final String password) {

        return "Login effettuato con successo!";
    }
}