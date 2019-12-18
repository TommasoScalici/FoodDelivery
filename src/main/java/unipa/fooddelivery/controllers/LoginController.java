package unipa.fooddelivery.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.models.User;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView getLoginView() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "login");
        return mav;
    }

    @GetMapping(value = "/logout")
    public ModelAndView getLogoutView(HttpSession session) {
        session.removeAttribute("user");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "logout");
        return mav;
    }

    @PostMapping(value = "/login/result")
    public @ResponseBody ModelAndView getLoginResultView(@RequestParam(value="username") final String username, 
                                                         @RequestParam(value="password") final String password,
                                                         HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/");
        session.setAttribute("user", new User(username, password));
        return mav;
    }
}