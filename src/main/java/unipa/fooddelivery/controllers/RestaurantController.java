package unipa.fooddelivery.controllers;

import java.util.*;
import java.util.stream.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @GetMapping(value = "/{category}")
    public ModelAndView getRestaurantsView(@PathVariable("category") final RestaurantCategory category) 
    {
        var mav = new ModelAndView("index");
        var restaurants = DataBase.getInstance().getRestaurants();
        var restaurantsFiltered = restaurants.stream()
                                             .filter(x -> x.getCategory().equals(category))
                                             .collect(Collectors.toList());

        mav.addObject("path", "restaurants");
        mav.addObject("category", category);
        mav.addObject("restaurants", restaurantsFiltered);
        return mav;
    }

    @GetMapping(value = "/{category}/{id}")
    public ModelAndView getRestaurantMenuView(@PathVariable("category") final RestaurantCategory category,
                                              @PathVariable("id") final long id, HttpSession session) 
    {
        var mav = new ModelAndView("index");
        var dishes = DataBase.getInstance().getDishes();

        var dishesFiltered = dishes.stream()
                                   .filter(x -> x.getRestaurant().getId() == id)
                                   .collect(Collectors.toList());


        mav.addObject("path", "dishes");
        mav.addObject("dishes", dishesFiltered);

        if(session.getAttribute("shoppingcart") == null)
            session.setAttribute("shoppingcart", new Hashtable<Long, Integer>());
        
        return mav;
    }
}