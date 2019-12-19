package unipa.fooddelivery.controllers;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class RestaurantsController {

    @GetMapping(value = "/restaurants")
    public ModelAndView getRestaurantsView() throws JsonParseException, JsonMappingException, IOException {
        var mav = new ModelAndView("index");
        mav.addObject("path", "restaurants");

        var objectMapper = new ObjectMapper();
        var restaurants = objectMapper.readValue(new File("./src/main/resources/static/json/restaurants.json"), List.class);
        mav.addObject("restaurants", restaurants);
        return mav;
    }
}