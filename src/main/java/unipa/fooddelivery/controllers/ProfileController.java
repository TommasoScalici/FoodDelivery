package unipa.fooddelivery.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @GetMapping()
    public ModelAndView getProfileView(HttpSession session) {
        var mav = new ModelAndView("index");
        session.getAttribute("user");
        mav.addObject("path", "profile");
        return mav;
    }
}