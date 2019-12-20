package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Menu
 */
public class Menu {

    private ArrayList<Dish> dishes = new ArrayList<>();
    private ArrayList<Dish> dailyMenu = new ArrayList<>();

    public Menu() { }

    //#region getters and setters
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Dish> getDailyMenu() {
        return dailyMenu;
    }

    public void setDailyMenu(ArrayList<Dish> dailyMenu) {
        this.dailyMenu = dailyMenu;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }
    //#endregion
}