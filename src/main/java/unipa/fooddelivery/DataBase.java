package unipa.fooddelivery;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;

import unipa.fooddelivery.models.*;

/**
 * Class for DataBase mock
 */
public final class DataBase {
    private final static String jsonPath = "./src/main/resources/static/json/";
    private static DataBase database;

    // #region mocked entities
    private List<Customer> customers = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();
    private List<DeliveryMan> deliverymen = new ArrayList<>();
    private List<Menu> menus = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    // #endregion

    private DataBase() { }
    
    //#region getters

    public static DataBase getInstance() {
        if(database == null)
            database = new DataBase();

        return database;
    }

    public List<Customer> getCustomers() {
        loadData("customers", Customer.class);
        return customers;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<DeliveryMan> getDeliveryMen() {
        return deliverymen;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //#endregion

    private void loadData(String entityName, Class<?> valueType) {
        try
        {
            var file = new File(jsonPath + entityName + ".json");
            var objectMapper = new ObjectMapper();

            // Volevo farla semplice, ma Java fa schifo e sono costretto a usare la Reflection

            var javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, valueType);
            var json = objectMapper.readValue(file, javaType);
            var field = this.getClass().getDeclaredField(entityName);
            field.setAccessible(true);
            field.set(this, json);
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    };
}