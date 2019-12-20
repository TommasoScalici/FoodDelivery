package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Order
 * 
 * Il ristorante non figura tra gli attributi, poiché è possibile raggruppare in
 * un ordine piatti da più ristoranti. Ogni piatto ha comunque un attributo che
 * fa riferimento al ristorante a cui appartiene
 */
public class Order {

    private Customer customer;
    private DeliveryMan deliveryMan;
    private List<Dish> dishesOrdered;
    private OrderStatus status = OrderStatus.PENDING;
    private float deliveryFee;

    public Order() { }

    public double getInvoiceTotalFee() {
        return dishesOrdered.stream().mapToDouble(d -> d.getPrice()).sum();
    }

    //#region getters and setters

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

    public List<Dish> getDishesOrdered() {
        return dishesOrdered;
    }

    public void setDishesOrdered(List<Dish> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    //#endregion
}