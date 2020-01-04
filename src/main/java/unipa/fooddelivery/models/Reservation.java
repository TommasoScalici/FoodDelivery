package unipa.fooddelivery.models;

import java.util.*;

public class Reservation {

    private long id;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dish> dishesOrdered;
    private Date reservationDate;
    private int seatsNumber;

    public Reservation() {
    }

    // #region getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public List<Dish> getDishesOrdered() {
        return dishesOrdered;
    }

    public void setDishesOrdered(List<Dish> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    //#endregion
}