package unipa.fooddelivery.controllers;

import java.util.stream.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants/{category}")
    public ModelAndView getRestaurantsView(@PathVariable RestaurantCategory category) 
    {   
              
    {
        var mav = new ModelAndView("index");
        var restaurants = DataBase.getInstance().getRestaurants();
        var restaurantsFiltered = restaurants.stream()
                                             .filter(x -> x.getCategory().equals(category))
                                             .collect(Collectors.toList());

        mav.addObject("path", "restaurants");
        mav.addObject("restaurants", restaurantsFiltered);
        return mav;
    }
    }
}