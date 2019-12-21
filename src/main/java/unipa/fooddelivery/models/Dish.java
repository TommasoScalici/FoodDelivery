package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Dish
 */
public class Dish {

    private String name;
    private DishCategory category;
    private Restaurant restaurant;
    private double price;
    private List<String> allergens;

    public Dish() { }

    public Dish(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    public Dish(String name, Restaurant restaurant, DishCategory category, double price) {
        this.name = name;
        this.restaurant = restaurant;
        this.category = category;
        this.price = price;
    }

    //#region getters and setters
    public String getName() {
        return name;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }
    //#endregion
}