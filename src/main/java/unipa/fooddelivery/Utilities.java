package unipa.fooddelivery;

import java.util.List;
import java.util.stream.*;

import unipa.fooddelivery.models.*;

public class Utilities {

    public static List<Dish> filterDishesByCategory(List<Dish> dishes, DishCategory category) {
        return dishes.stream()
                     .filter(x -> x.getCategory().equals(category))
                     .collect(Collectors.toList());
    }
    
}