package com.selfeval.eurder.api.user.mappers;

import com.selfeval.eurder.api.user.dto.CreateUserDTO;
import com.selfeval.eurder.domain.ValidationTools;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {
    public User mapToUser(CreateUserDTO createUserDTO){
        ValidationTools.ifObjectIsNull_ThenThrowException(createUserDTO.getName());
        ValidationTools.ifObjectIsNull_ThenThrowException(createUserDTO.getContact());
        ValidationTools.ifObjectIsNull_ThenThrowException(createUserDTO.getContact().getAddress());
        return new User(createUserDTO.getName(), createUserDTO.getContact(), Role.CUSTOMER);
    }


}
