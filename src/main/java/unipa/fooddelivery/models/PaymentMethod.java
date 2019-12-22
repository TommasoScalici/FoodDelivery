package unipa.fooddelivery.models;

public enum PaymentMethod {
    CASH("Contanti"),
    CREDITCARD("Carta di credito"),
    PAYPAL("PayPal");

    private final String displayValue;
     
    private PaymentMethod(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}