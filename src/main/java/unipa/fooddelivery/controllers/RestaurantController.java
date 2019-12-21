package unipa.fooddelivery.controllers;

import java.util.stream.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

@Controller
public class RestaurantController {

    @GetMapping(value = "/restaurants/{category}")
    public ModelAndView getRestaurantsView(@PathVariable("category") final RestaurantCategory category, HttpServletRequest request) 
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

    @GetMapping(value = "/restaurants/{category}/{id}")
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

        session.setAttribute("ShoppingCart", dishesFiltered);

        return mav;
    }
}