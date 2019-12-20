package unipa.fooddelivery.models;

public enum DishCategory
{
    APPETIZER("Antipasto"),
    FIRST("Primo"),
    SECOND("Secondo"),
    PIZZA("Pizza"),
    DESSERT("Dolce"),
    FRUITS("Frutta"),
    DRINKS("Bevande"),
    WINE("Vini");

    private final String displayValue;
     
    private DishCategory(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}