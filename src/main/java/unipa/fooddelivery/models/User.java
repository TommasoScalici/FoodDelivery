package unipa.fooddelivery.models;

import java.util.*;

/**
 * Model POJO class for User
 */
public abstract class User {

    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String telephoneNumber;
    private Address address = new Address();
    private Date birthdate;

    // Implementazione di Abstraction Factory, questo metodo restituisce l'istanza concreta di User adatta al contesto
    public static User getFactory(String type) {
        switch (type) {
            case "Customer":
                return new Customer();
            case "DeliveryMan":
                return new DeliveryMan();
            case "RestaurantOwner":
                return new RestaurantOwner();
            default: 
                return null;
        }
    }

    protected User() { }

    protected User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // #region getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // #endregion
}