package unipa.fooddelivery.models;

/**
 * Model POJO class for DeliveryMan
 */
public class DeliveryMan extends User {

    private boolean isAvailable;

    public DeliveryMan() {
        super();
    }

    public DeliveryMan(String username, String password) {
        super(username, password);
    }

//#region getters and setters    
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
//#endregion
}