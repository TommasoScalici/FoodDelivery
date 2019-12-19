package unipa.fooddelivery.models;

/**
 * Model POJO class for Restaurant
 */
public class Restaurant {

    private long id;
    private String name;
    private String address;
    private String email;
    private String telephoneNumber;
    private String webSite;
    private RestaurantCategory category;

    public Restaurant(String name) {
        this.name = name;
    }

    // #region getters and setters
    public long getId() {
        return id;
    }

    public RestaurantCategory getCategory() {
        return category;
    }

    public void setCategory(RestaurantCategory category) {
        this.category = category;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //#endregion
}