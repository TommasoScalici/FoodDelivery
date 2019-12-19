package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Menu
 */
public class Menu {

    private ArrayList<Dish> dishes = new ArrayList<>();
    private ArrayList<Dish> dailyMenu = new ArrayList<>();

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Dish> getDailyMenu() {
        return dailyMenu;
    }
}