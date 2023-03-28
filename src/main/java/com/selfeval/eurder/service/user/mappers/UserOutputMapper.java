package com.selfeval.eurder.service.user.mappers;

import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserDTO toUserDto(User user) {
        return new UserDTO(
                new Name(user.getName().getFirstName(),
                        user.getName().getLastName()),
                user.getRole(),
                user.getId()
        );
    }
}
