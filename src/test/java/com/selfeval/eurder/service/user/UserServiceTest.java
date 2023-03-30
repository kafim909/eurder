package com.selfeval.eurder.service.user;

import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.*;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    private UserService userService;
    private UserRepository userRepositoryMock;
    private User user;
    private UserMinimumDataDTO userDTO;

    @BeforeEach
    void setUp() {
        userRepositoryMock = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepositoryMock);
        user = new User(
                new Name("Tournay", "Maxime"),
                new Contact(new Address(
                        "Brussels",
                        "Belgiun",
                        "1030",
                        "Avenue General Eisenhower",
                        30),
                        "123456789",
                        "coucou@coucou.coucou"),
                Role.CUSTOMER);
    }

    @Test
    void createUser_WhenCreatingUser_thenSameUserShouldBeReturned() {
        Mockito.when(userRepositoryMock.addUser(user)).thenReturn(user);
        assertEquals(user, userService.createUser(user));
    }





}