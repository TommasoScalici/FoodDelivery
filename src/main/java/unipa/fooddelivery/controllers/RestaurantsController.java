package unipa.fooddelivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants")
    public ModelAndView getRestaurantsView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");
        return mav;
    }
}