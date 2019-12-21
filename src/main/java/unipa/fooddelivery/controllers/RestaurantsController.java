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
    public ModelAndView getRestaurantsView() 
    {
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");

        var restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("La Dolce Vita", RestaurantCategory.ITALIAN, 10));
        restaurants.add(new Restaurant("L'Arte Bianca", RestaurantCategory.PIZZA, 0));
        restaurants.add(new Restaurant("Chan Sushi Bar", RestaurantCategory.SUSHI, 18));

        var dishes = new ArrayList<Dish>();
        dishes.add(new Dish("Lasagne", restaurants.get(0), DishCategory.FIRST, 10));
        dishes.add(new Dish("Margherita", restaurants.get(1), DishCategory.PIZZA, 5));
        dishes.add(new Dish("Sashimi", restaurants.get(2), DishCategory.SECOND, 14));

        DataBase.getInstance().getDishes().addAll(dishes);
        DataBase.getInstance().saveChangesForEntity(Dish.class);

        DataBase.getInstance().getRestaurants().addAll(restaurants);
        DataBase.getInstance().saveChangesForEntity(Restaurant.class);

        return mav;
    }
}