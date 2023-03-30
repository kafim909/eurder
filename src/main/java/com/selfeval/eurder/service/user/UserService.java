package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.api.user.mappers.UserOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.addUser(user);
    }
}
