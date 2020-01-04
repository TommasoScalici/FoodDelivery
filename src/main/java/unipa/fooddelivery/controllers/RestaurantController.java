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
@RequestMapping(value = "{orderType}/restaurants")
public class RestaurantController {

    @GetMapping(value = "{category}")
    public ModelAndView getRestaurantsView(@PathVariable("category") final RestaurantCategory category, HttpSession session) 
    {
        if(session.getAttribute("reservation") == null)
			session.setAttribute("reservation", new Hashtable<Integer, Integer>());

        if(session.getAttribute("shoppingcart") == null)
			session.setAttribute("shoppingcart", new Hashtable<Integer, Integer>());

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

    @GetMapping(value = "{category}/{id}")
    public ModelAndView getRestaurantMenuView(@PathVariable("category") final RestaurantCategory category,
                                              @PathVariable("orderType") final String orderType,
                                              @PathVariable("id") final long id, HttpSession session) 
    {
        if(session.getAttribute("reservation") == null)
			session.setAttribute("reservation", new Hashtable<Integer, Integer>());

        if(session.getAttribute("shoppingcart") == null)
			session.setAttribute("shoppingcart", new Hashtable<Integer, Integer>());

        var mav = new ModelAndView("index");
        var dishes = DataBase.getInstance().getDishes();

        var dishesFiltered = dishes.stream()
                                   .filter(x -> x.getRestaurant().getId() == id)
                                   .collect(Collectors.toList());


        mav.addObject("path", "dishes");
        mav.addObject("orderType", orderType);
        mav.addObject("dishes", dishesFiltered);
        
        return mav;
    }
}