package com.selfeval.eurder.api.user.dto;

import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private final int id;
    private final Name name;
    private final Role role;

    public CustomerDTO(int id, Name name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }
}
