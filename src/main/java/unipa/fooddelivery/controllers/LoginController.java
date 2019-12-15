package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "welcome");
        return mav;
    }


    @RequestMapping(value = "/login")
    public ModelAndView getLoginView() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "login");
        return mav;
    }

    @RequestMapping(value = "/register")
    public ModelAndView getRegisterView() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "register");
        return mav;
    }

    @RequestMapping(value = {"/login/result"})
    public @ResponseBody String getLoginResultView(@RequestParam(value="username") final String username, 
                                                   @RequestParam(value="password") final String password) {

        return "Login effettuato con successo!";
    }
}