package unipa.fooddelivery.models;

public enum RestaurantCategory
{
    CHINESE("Cinese"),
    ITALIAN("Italiano"),
    JAPANESE("Giapponese"),
    HAMBURGER("Hamburger"),
    SANDWICHES("Panini"),
    PIZZA("Pizza"),
    SUSHI("Sushi"),
    SWEET("Dolci");

    private final String displayValue;
     
    private RestaurantCategory(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}

