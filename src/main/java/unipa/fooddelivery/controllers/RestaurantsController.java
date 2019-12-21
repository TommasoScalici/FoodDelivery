package unipa.fooddelivery.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.DataBase;
import unipa.fooddelivery.models.*;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants")
    public ModelAndView getRestaurantsView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");
        return mav;
    }
}