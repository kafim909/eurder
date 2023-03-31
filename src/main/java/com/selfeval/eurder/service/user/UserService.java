package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.ValidationTools;
import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.api.user.mappers.UserOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.addUser(user);
    }

    public List<User> getAllCustomers(int userId) {
        ValidationTools.UserAnAdminOrElseThrowException(userId);
        return userRepository.getUserList()
                        .stream().filter(user -> user.getRole().equals(Role.CUSTOMER))
                        .collect(Collectors.toList());
    }

    public User getCustomerById(int adminId, int customerId) {
        return getAllCustomers(adminId)
                .stream()
                .filter(user -> user.getId() == customerId)
                .findFirst()
                .orElseThrow();

    }
}
