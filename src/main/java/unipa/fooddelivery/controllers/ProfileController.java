package unipa.fooddelivery.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class ProfileController {

    @GetMapping(value = "/profile")
    public ModelAndView getProfileView(HttpSession session) {
        ModelAndView mav = new ModelAndView("index");
        session.getAttribute("user");
        mav.addObject("path", "profile");
        return mav;
    }
}