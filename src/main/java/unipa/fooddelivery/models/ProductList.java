package unipa.fooddelivery.models;

import java.util.*;

import unipa.fooddelivery.DataBase;


public class ProductList {

	private List<Dish> dishes;

	public ProductList() {
		this.dishes = new ArrayList<Dish>();
        this.dishes.add(DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == 1).findFirst().get());
        this.dishes.add(DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == 2).findFirst().get());
        this.dishes.add(DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == 3).findFirst().get());
        this.dishes.add(DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == 4).findFirst().get());
        this.dishes.add(DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == 5).findFirst().get());
	}

	public List<Dish> findAll() {
		return this.dishes;
	}

	public Dish find(String id) {
		for (Dish dishes : this.dishes) {
			//if (dishes.getId().equalsIgnoreCase(id)) {
				return dishes;
			//}
		}
		return null;
	}

}