package com.selfeval.eurder.domain.user.baseclasses;

public class Contact {
    private final Address address;
    private final String phoneNumber;
    private final String mailAddress;

    public Contact(Address address, String phoneNumber, String mailAddress) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getCity() {
        return address.city;
    }

    public String getCountry() {
        return address.country;
    }

    public String getPostCode() {
        return address.postCode;
    }

    public String getStreet() {
        return address.street;
    }

    public int getHouseNumber() {
        return address.houseNumber;
    }

    public static class Address {
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


    }
}
