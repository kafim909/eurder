package com.selfeval.eurder.api.user.mappers;

import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserMinimumDataDTO toMinimumDataDto(User user) {
        return new UserMinimumDataDTO(
                new Name(user.getName().getFirstName(),
                        user.getName().getLastName()),
                user.getRole(),
                user.getId()
        );
    }
}
