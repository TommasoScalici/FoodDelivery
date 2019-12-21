package unipa.fooddelivery.controllers;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.Restaurant;
import unipa.fooddelivery.models.RestaurantCategory;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants/{category}")
    public ModelAndView getRestaurantsView(@PathVariable RestaurantCategory category) 
    {   
        
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");

        var dishes = DataBase.getInstance().getDishes();
        var dishe = dishes.stream()
                        .filter(x -> x.getRestaurant().equals(category))
                        .findFirst();
              
        return mav;
    }
}