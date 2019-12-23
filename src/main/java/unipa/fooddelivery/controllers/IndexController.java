package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping()
    public ModelAndView index() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "welcome");
        return mav;
    }
}