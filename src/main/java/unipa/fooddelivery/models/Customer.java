package unipa.fooddelivery.models;

/**
 * Model POJO class for Customer
 */
public class Customer extends User {

    public Customer(long id) {
        super(id);
    }

    public Customer(long id, String username, String password) {
        super(id, username, password);
    }
}