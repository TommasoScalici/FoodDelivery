package unipa.fooddelivery;

import java.util.*;
import java.util.stream.*;

import unipa.fooddelivery.models.*;

public class Utilities
 {

    public static List<Dish> filterDishesByCategory(List<Dish> dishes, DishCategory category) {
        
        return dishes.stream()
                     .filter(x -> x.getCategory().equals(category))
                     .collect(Collectors.toList());
    }

    public static double getTotal(Enumeration<Dish> dishes, double deliveryFee) {
         
        var dishesList = Collections.list(dishes);
        return dishesList.stream().mapToDouble(d -> d.getPrice()).sum() + deliveryFee;
    }
}