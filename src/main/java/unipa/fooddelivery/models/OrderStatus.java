package unipa.fooddelivery.models;

import java.util.*;

public enum OrderStatus {
    ACCEPTED("Accettato e in preparazione"),
    CANCELED("Annullato"),
    DELIVERED("Consegnato"),
    PENDING("In attesa di accettazione"), 
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

    public Optional<OrderStatus> next() {
        switch (this) {
            case CANCELED:
            case DELIVERED:
                return Optional.empty();
            case PENDING:
                return Optional.of(ACCEPTED);
            case ACCEPTED:
                return Optional.of(TOCOLLECTPOINT);
            case TOCOLLECTPOINT:
                return Optional.of(WAITING);
            case TODESTINATION:
                return Optional.of(DELIVERED);
            case WAITING:
                return Optional.of(TODESTINATION);
            default:
                return Optional.empty();
        }
    }
}