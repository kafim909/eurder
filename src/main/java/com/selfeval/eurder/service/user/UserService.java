package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.UserDTO;
import com.selfeval.eurder.service.user.mappers.UserInputMapper;
import com.selfeval.eurder.service.user.mappers.UserOutputMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserOutputMapper outputMapper;

    public UserService(UserRepository userRepository, UserOutputMapper outputMapper) {
        this.userRepository = userRepository;
        this.outputMapper = outputMapper;
    }

    public UserDTO createUser(User user){
        return outputMapper.toUserDto(userRepository.addUser(user));
    }
}
