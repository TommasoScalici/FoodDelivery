package unipa.fooddelivery.models;

import javax.servlet.http.HttpSession;


public class Item 
{
    private Dish dish;
    private int quantity;

    public Item(Dish find, int i) {
	}

	/**
     * @return the dish
     */
    public Dish getDish() {
        return dish;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    

    /**
     * @param dish the dish to set
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void item() {
    }

    public void item(Dish dish, int quantity)
    {
        this.quantity = quantity;
        this.dish = dish;
    }

	public HttpSession getProduct() {
		return null;
	}


}

