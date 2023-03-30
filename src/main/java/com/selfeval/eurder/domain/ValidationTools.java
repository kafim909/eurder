package com.selfeval.eurder.domain;

import com.selfeval.eurder.domain.exceptions.UnauthorizedException;
import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Component;

@Component
public class ValidationTools {
    private static UserRepository userRepository;

    public ValidationTools(UserRepository userRepository) {
        ValidationTools.userRepository = userRepository;
    }

    public static void UserAnAdminOrElseThrowException(int id) {
        if (!userRepository.getUserById(id).getRole().equals(Role.ADMIN)) {
            throw new UnauthorizedException("User does not have the rights to execute task");
        }
    }

    public static void UserACustomerOrElseThrowException(int id) {
        if (!userRepository.getUserById(id).getRole().equals(Role.CUSTOMER)) {
            throw new UnauthorizedException("User does not have the rights to execute task");
        }
    }
}
