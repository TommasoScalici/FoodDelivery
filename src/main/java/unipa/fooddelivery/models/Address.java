package unipa.fooddelivery.models;

public class Address
{
    private String country;
    private String city;
    private String province;
    private String street;
    private String number;
    private String zip;

    public Address() {
        super();
    }

    public Address(String country, String city, String province, String street, String number, String zip) {
        this.country = country;
        this.city = city;
        this.province = province;
        this.street = street;
        this.number = number;
        this.zip = zip;
    }

    //#region getters and setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    //#endregion
}