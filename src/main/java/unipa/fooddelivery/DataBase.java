package unipa.fooddelivery;

/**
 * DataBase
 */

import java.util.*;
import unipa.fooddelivery.models.*;

public final class DataBase {
    private static ArrayList<Restaurant> restaurants;
    private static ArrayList<Customer> customers;
    private static ArrayList<DeliveryMan> deliveryMen;

    public static ArrayList<Customer> getCustomers() {

        return customers;
    }

    public static ArrayList<DeliveryMan> getDeliveryMen() {
        return deliveryMen;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    
}