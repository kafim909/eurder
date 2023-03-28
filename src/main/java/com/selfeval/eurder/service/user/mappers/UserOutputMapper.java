package com.selfeval.eurder.service.user.mappers;

import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.UserMinimumDataDTO;
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
