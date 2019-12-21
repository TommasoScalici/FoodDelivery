package unipa.fooddelivery.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.models.*;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants")
    public ModelAndView getRestaurantsView() 
    {
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");

        var restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("La Dolce Vita", RestaurantCategory.ITALIAN));
        restaurants.add(new Restaurant("L'Arte Bianca", RestaurantCategory.PIZZA));
        return mav;
    }
}