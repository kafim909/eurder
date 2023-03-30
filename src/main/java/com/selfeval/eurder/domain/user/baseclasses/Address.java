package com.selfeval.eurder.domain.user.baseclasses;

public class Address {
    private final String city;
    private final String country;
    private final String postCode;
    private final String street;
    private final int houseNumber;

    public Address(String city, String country, String postCode, String street, int number) {
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = number;
    }

    public Address(Address addressCopy){
        city = addressCopy.getCity();
        country = addressCopy.getCountry();
        postCode = addressCopy.getPostCode();
        street = addressCopy.getStreet();
        houseNumber = addressCopy.getHouseNumber();
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
