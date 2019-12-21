package unipa.fooddelivery.models;

public class Reservation {

    private Customer customer;
    private Restaurant restaurant;

    public Reservation() { }

    //#region getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    //#endregion
}