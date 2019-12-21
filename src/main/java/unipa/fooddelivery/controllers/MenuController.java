package unipa.fooddelivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.models.Dish;

@Controller
public class MenuController 
{

    @GetMapping(value = "/menu")
    public ModelAndView getMenuView() 
    {
        var mav = new ModelAndView("index");
        mav.addObject("path", "menu");
        return mav;
    }

    @GetMapping(value = "/menu")
    public ModelAndView getMenuView() 
    {
    var dish = new Dish(name,category,restaurant,price,allergens);

        dish.setName(name);
    }

}