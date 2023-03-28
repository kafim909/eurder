package com.selfeval.eurder.service.user.dto;

import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;

public class CreateUserDTO {
    private final Name name;
    private final Contact contact;

    public CreateUserDTO(Name name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

}
