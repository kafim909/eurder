package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import com.selfeval.eurder.service.user.dto.CreateUserDTO;
import com.selfeval.eurder.service.user.dto.UserDTO;
import com.selfeval.eurder.service.user.mappers.UserOutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private UserRepository userRepositoryMock;
    private UserOutputMapper outputMapperMock;
    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        outputMapperMock = Mockito.mock(UserOutputMapper.class);
        userRepositoryMock = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepositoryMock, outputMapperMock);
        user = new User(
                new Name("Tournay", "Maxime"),
                new Contact(new Contact.Address(
                        "Brussels",
                        "Belgiun",
                        "1030",
                        "Avenue General Eisenhower",
                        30),
                        "123456789",
                        "coucou@coucou.coucou"),
                Role.CUSTOMER);
//        userDTO = new UserDTO(user.getName(), user.getRole(), user.getId());
    }
    @Test
    void createUser_whenCreatingUser_thenAddUserWithUserRepository() {
        userService.createUser(user);
        Mockito.verify(userRepositoryMock).addUser(user);
    }



}