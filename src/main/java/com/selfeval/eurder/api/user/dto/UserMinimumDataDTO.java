package com.selfeval.eurder.api.user.dto;

import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Role;

public class UserMinimumDataDTO {
    private final Name name;
    private final Role role;
    private final int id;

    public UserMinimumDataDTO(Name name, Role role, int id) {
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
