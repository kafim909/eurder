package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.UserMinimumDataDTO;
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

    public UserMinimumDataDTO createUser(User user){
        return outputMapper.toMinimumDataDto(userRepository.addUser(user));
    }
}
