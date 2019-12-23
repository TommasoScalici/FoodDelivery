package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Order
 * 
 * Il ristorante non figura tra gli attributi, poiché è possibile raggruppare in
 * un ordine piatti da più ristoranti. Ogni piatto ha comunque un attributo che
 * fa riferimento al ristorante a cui appartiene.
 */
public class Order {

    private long id;
    private Date deliveryDate;
    private Date orderDate;
    private Customer customer;
    private DeliveryMan deliveryMan;
    private List<Dish> dishesOrdered;
    private OrderStatus status = OrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private double deliveryFee;
    private boolean isPaid;


    public Order() { }

    public Order(Customer customer, DeliveryMan deliveryMan, List<Dish> dishesOrdered) {
        this.customer = customer;
        this.deliveryMan = deliveryMan;
        this.dishesOrdered = dishesOrdered;
     }

    public void advanceStatus() {
        var nextStatus = status.next();
        if(nextStatus.isPresent())
            status = nextStatus.get();
    }

    public void cancelOrder() {
        status = OrderStatus.CANCELED;
    }

    public double getInvoiceTotalFee() {
        return dishesOrdered.stream().mapToDouble(d -> d.getPrice()).sum()
               + deliveryFee;
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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    //#endregion
}