package unipa.fooddelivery;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.*;
import com.fasterxml.jackson.databind.module.*;

import unipa.fooddelivery.models.*;

/**
 * Class for DataBase mock
 */
public final class DataBase {
    private final static String jsonPath = "./src/main/resources/static/json/";
    private final static Hashtable<Class<?>, String> models = new Hashtable<>();
    private static ObjectMapper mapper;
    private static DataBase database;

    // #region mocked entities
    private List<Customer> customers = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();
    private List<DeliveryMan> deliverymen = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<RestaurantOwner> restaurantOwners = new ArrayList<>();
    // #endregion

    // Implementazione Singleton

    private DataBase() { }

    public static DataBase getInstance() {
        if(database == null)
        {
            database = new DataBase();

            var builder = JsonMapper.builder();
            var module = new SimpleModule();
            module.addKeyDeserializer(Dish.class, new CustomMapDishKeyDeserializer());
            
            builder.addModule(module);
            builder.findAndAddModules();

            mapper = builder.build();


            /* Hashtable che mappa le classi di modello / POJO ai rispettivi
            *  file JSON che costituiscono il database non relazionale.
            *  L'inserimento è fatto hard-coded per semplicità, se si aggiungono nuovi modelli o se ne alterano i nomi
            *  bisogna aggiornare la lista manualmente altrimenti potrebbe crashare tutto, quindi
            *  !!! FARE ATTENZIONE !!!
            */
 
            models.put(Customer.class, "customers");
            models.put(Dish.class, "dishes");
            models.put(DeliveryMan.class, "deliverymen");
            models.put(Order.class, "orders");
            models.put(Reservation.class, "reservations");
            models.put(Restaurant.class, "restaurants");
            models.put(RestaurantOwner.class, "restaurantOwners");
        }

        return database;
    }

    // Implementazione Singleton


    //#region getters

    // In questi metodi, i dati vengono caricati effettivamente dal DB solo quando vengono richiesti
    // I campi vengono dunque usati come dei virtual proxy, per poi effettuara un lazy loading

    public List<Customer> getCustomers() {
        loadData("customers", Customer.class);
        return customers;
    }

    public List<DeliveryMan> getDeliverymen() {
        loadData("deliverymen", DeliveryMan.class);
        return deliverymen;
    }

    public List<Dish> getDishes() {
        loadData("dishes", Dish.class);
        return dishes;
    }

    public List<Order> getOrders() {
        loadData("orders", Order.class);
        return orders;
    }

    public List<Reservation> getReservations() {
        loadData("reservations", Reservation.class);
        return reservations;
    }

    public List<Restaurant> getRestaurants() {
        loadData("restaurants", Restaurant.class);
        return restaurants;
    }

    public List<RestaurantOwner> getRestaurantOwners() {
        loadData("restaurantOwners", RestaurantOwner.class);
        return restaurantOwners;
    }

    //#endregion

    public List<User> getAllUsers() {
        var users = new ArrayList<User>();
        
        users.addAll(getCustomers());
        users.addAll(getDeliverymen());
        users.addAll(getRestaurantOwners());

        return users;
    }

    private void loadData(String entityName, Class<?> valueType) {
        try
        {
            var file = new File(jsonPath + entityName + ".json");

            var javaType = mapper.getTypeFactory().constructCollectionType(List.class, valueType);
            var json = mapper.readValue(file, javaType);
            var field = this.getClass().getDeclaredField(entityName);
            field.setAccessible(true);
            field.set(this, json);
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    }

    /**
     * This method serialize the mock entity list to JSON. Use it to make changes to database permanent.
     * @param entityType The entity type you want to serialize.
     */
    public void saveChangesForEntity(Class<?> entityType) {
        try
        {
            Field fieldToSave = null;

            for (Field field : this.getClass().getDeclaredFields())
            {
                var type = field.getGenericType();

                if(type instanceof ParameterizedType)
                {
                    var pType = ((ParameterizedType)type).getActualTypeArguments()[0];
                    if(pType.equals(entityType))
                        fieldToSave = field;
                }
            }
            
            var entityName = models.get(entityType);
            var file = new File(jsonPath + entityName + ".json");

            mapper.writeValue(file, fieldToSave.get(this));
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
}