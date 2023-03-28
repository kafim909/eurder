package com.selfeval.eurder.domain.user.baseclasses;

public class User {
    private final int id;
    private static int counter;
    private final Name name;
    private final Contact contact;
    private final Role role;

    public User(Name name, Contact contact, Role role) {
        id = ++counter;
        this.name = name;
        this.contact = contact;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public int getId() {
        return id;
    }
}
