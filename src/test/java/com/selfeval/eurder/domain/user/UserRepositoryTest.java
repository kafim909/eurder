package com.selfeval.eurder.domain.user;

import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Address;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
class UserRepositoryTest {

    private User myUser;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        myUser = new User(
                new Name("Max", "Jean"),
                new Contact(new Address(
                        "BossTown",
                        "KingsLand",
                        "10",
                        "Rue du Succes",
                        10),
                        "0458975645",
                        "pascalis.leboss@gmail.com"),
                Role.ADMIN);
    }

    @Test
    void getUserById_givenAnAddedUser_whenSearchingWithId_ThenFindUser() {
        userRepository.addUser(myUser);
        assertEquals(myUser, userRepository.getUserById(myUser.getId()));
    }

}