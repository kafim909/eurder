package com.selfeval.eurder.domain.user.baseclasses;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(Name nameCopy){
        firstName = nameCopy.getFirstName();
        lastName = nameCopy.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
