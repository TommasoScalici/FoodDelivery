package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public ModelAndView index() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "welcome");
        return mav;
    }
}