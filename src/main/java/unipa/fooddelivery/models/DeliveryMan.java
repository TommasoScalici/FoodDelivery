package unipa.fooddelivery.models;

/**
 * Model POJO class for DeliveryMan
 */
public class DeliveryMan extends User {

    public DeliveryMan(long id) {
        super(id);
    }

    public DeliveryMan(long id, String username, String password) {
        super(id, username, password);
    }
}