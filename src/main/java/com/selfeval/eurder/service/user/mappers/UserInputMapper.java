package com.selfeval.eurder.service.user.mappers;

import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {
    public User fromCreateUserDtoToUser(CreateUserDTO createUserDTO){
        return new User(createUserDTO.getName(), createUserDTO.getContact(), Role.CUSTOMER);
    }


}
