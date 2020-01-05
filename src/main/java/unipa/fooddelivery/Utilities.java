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

    public static double getTotal(Hashtable<Dish, Integer> dishes, double deliveryFee) {
         
        return dishes.entrySet().stream().mapToDouble(x -> x.getKey().getPrice() * x.getValue()).sum();
    }

    public static Hashtable<Dish, Integer> getDishesFromIDs(Hashtable<Long, Integer> dishesIDs)
	{
		Hashtable<Dish, Integer> dishes = new Hashtable<>();
		var dishesFromDB = DataBase.getInstance().getDishes();
			
		dishesIDs.forEach((k, v) -> {
			var optionalDish = dishesFromDB.stream().filter(x -> x.getId() == k).findFirst();

			if(optionalDish.isPresent())
				dishes.put(optionalDish.get(), v);
		});

		return dishes;
	}
}