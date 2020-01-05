package unipa.fooddelivery.models;

import java.time.*;
import java.util.*;

public class Reservation {

    private long id;
    private Customer customer;
    private Restaurant restaurant;
    private Map<Dish, Integer> dishesOrdered;
    private PaymentMethod paymentMethod;
    private LocalDateTime reservationDate;
    private int seatsNumber;

    public Reservation() {
    }

    public double getInvoiceTotalFee() {
        return dishesOrdered.entrySet()
                            .stream()
                            .mapToDouble(x -> x.getKey().getPrice() * x.getValue())
                            .sum();
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Map<Dish, Integer> getDishesOrdered() {
        return dishesOrdered;
    }

    public void setDishesOrdered(Map<Dish, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    //#endregion
}