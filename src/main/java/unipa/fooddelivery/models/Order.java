package unipa.fooddelivery.models;

import java.time.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

import unipa.fooddelivery.*;

/**
 * Model POJO class for Order
 * 
 * Il ristorante non figura tra gli attributi, poiché è possibile raggruppare in
 * un ordine piatti da più ristoranti. Ogni piatto ha comunque un attributo che
 * fa riferimento al ristorante a cui appartiene.
 */
public class Order {

    private long id;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;  
    private Customer customer;
    private DeliveryMan deliveryMan;

    @JsonSerialize(keyUsing = CustomMapDishKeySerializer.class)
    private Map<Dish, Integer> dishesOrdered;
    private OrderStatus status = OrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private double deliveryFee;
    private boolean isPaid;


    public Order() { }

    public void advanceStatus() {
        var nextStatus = status.next();
        if(nextStatus.isPresent())
            status = nextStatus.get();
    }

    public void cancelOrder() {
        status = OrderStatus.CANCELED;
    }

    @JsonIgnore()
    public double getInvoiceTotalFee() {
        return dishesOrdered.entrySet()
                            .stream()
                            .mapToDouble(x -> x.getKey().getPrice() * x.getValue())
                            .sum() + deliveryFee;
    }

    //#region getters and setters

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

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Map<Dish, Integer> getDishesOrdered() {
        return dishesOrdered;
    }

    public void setDishesOrdered(Map<Dish, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    //#endregion
}