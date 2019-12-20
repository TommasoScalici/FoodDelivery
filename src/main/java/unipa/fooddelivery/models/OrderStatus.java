package unipa.fooddelivery.models;

public enum OrderStatus {
    ACCEPTED("Accettato"),
    CANCELED("Annullato"),
    PENDING("In attesa di accettazione"),
    PREPARING("In preparazione"),
    TOCOLLECTPOINT("Il fattorino sta andando a ritirare il tuo ordine"),
    TODESTINATION("Il fattorino sta per consegnare il tuo ordine"),
    WAITING("Il fattorino è sul luogo di ritiro, in attesa che l'ordine sia pronto");

    private final String displayValue;
     
    private OrderStatus(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}