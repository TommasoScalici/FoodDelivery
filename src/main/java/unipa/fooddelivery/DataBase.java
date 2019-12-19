package unipa.fooddelivery;

import java.io.File;




import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import unipa.fooddelivery.models.*;

/**
 * Class for DataBase mock
 */
public final class DataBase {
    private static DataBase database;
    private List<Customer> customers;
    private List<DeliveryMan> deliveryMen;
    private List<Restaurant> restaurants;

    private DataBase() {
        var objectMapper = new ObjectMapper();
        try {
            customers = objectMapper.readValue(new File("./src/main/resources/static/json/customers.json"), List.class);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }


    public static DataBase getInstance() {
        if(database == null)
            database = new DataBase();
        
        return database;
    }

    public List<Customer> getCustomers() {

        return customers;
    }

    public List<DeliveryMan> getDeliveryMen() {
        return deliveryMen;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}