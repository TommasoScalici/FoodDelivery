package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for Restaurant
 */
public class Restaurant {

    private double minimumOrderFee;
    private String name;
    private String address;
    private String email;
    private String telephoneNumber;
    private String webSite;
    private RestaurantCategory category;
    private List<Dish> dishes;
    private List<Dish> dailyMenu;

    public Restaurant() { }

    public Restaurant(String name) {
        this.name = name;
    }
    
    public Restaurant(String name, RestaurantCategory category, double minimumOrderFee) {
        this.name = name;
        this.category = category;
        this.minimumOrderFee = minimumOrderFee;
    }


    // #region getters and setters
    
    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Dish> getDailyMenu() {
        return dailyMenu;
    }

    public void setDailyMenu(List<Dish> dailyMenu) {
        this.dailyMenu = dailyMenu;
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

    public double getMinimumOrderFee() {
		return minimumOrderFee;
	}

	public void setMinimumOrderFee(double minimumOrderFee) {
		this.minimumOrderFee = minimumOrderFee;
	}

    //#endregion
}