package com.selfeval.eurder.api.user.mappers;

import com.selfeval.eurder.api.user.dto.CreateUserDTO;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {
    public User mapToUser(CreateUserDTO createUserDTO){
        return new User(createUserDTO.getName(), createUserDTO.getContact(), Role.CUSTOMER);
    }


}
