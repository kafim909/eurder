package com.selfeval.eurder.api.user.dto;

import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Role;

public class DetailedCustomerDTO {
    private final int id;
    private final Name name;
    private final Contact contact;
    private final Role role;

    public DetailedCustomerDTO(int id, Name name, Contact contact, Role role) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Role getRole() {
        return role;
    }
}
