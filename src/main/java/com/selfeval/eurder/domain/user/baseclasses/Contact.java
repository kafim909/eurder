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

    public Contact(Contact contactCopy) {
        this.address = new Address(contactCopy.getAddress());
        this.phoneNumber = contactCopy.getPhoneNumber();
        this.mailAddress = contactCopy.getMailAddress();
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }
}
