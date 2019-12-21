package unipa.fooddelivery.controllers;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Locale.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
=======
import java.util.stream.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
>>>>>>> 46ab00ce627cb9837760d9eb069498a83eca6645
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.Restaurant;
import unipa.fooddelivery.models.RestaurantCategory;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants/{category}")
    public ModelAndView getRestaurantsView(@PathVariable RestaurantCategory category) 
<<<<<<< HEAD
    {   
        
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");

        var dishes = DataBase.getInstance().getDishes();
        var dishe = dishes.stream()
                        .filter(x -> x.getRestaurant().equals(category))
                        .findFirst();
              
=======
    {
        var mav = new ModelAndView("index");
        var restaurants = DataBase.getInstance().getRestaurants();
        var restaurantsFiltered = restaurants.stream()
                                             .filter(x -> x.getCategory().equals(category))
                                             .collect(Collectors.toList());

        mav.addObject("path", "restaurants");
        mav.addObject("restaurants", restaurantsFiltered);
>>>>>>> 46ab00ce627cb9837760d9eb069498a83eca6645
        return mav;
    }
}