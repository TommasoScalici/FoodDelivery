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

<<<<<<< HEAD
    public static double getTotal(Hashtable<Dish,Integer> dishes, double deliveryFee) 
    {
=======
    public static double getTotal(Hashtable<Dish, Integer> dishes, double deliveryFee) {
         
>>>>>>> 15b6be742a601c9acf95b1eb7a0877b305fcc9b7
        return dishes.entrySet().stream().mapToDouble(x -> x.getKey().getPrice() * x.getValue()).sum();
    }
}