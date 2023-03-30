package com.selfeval.eurder.domain.user;

import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.Role;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public UserRepository() {
        addDefaultAdminUser();
    }

    /*-------- add default admin user | ID = 1 ----------*/
    private void addDefaultAdminUser(){
        userList.add(new User(
                new Name("Pascal", "LeBoss"),
                new Contact(new Contact.Address(
                        "BossTown",
                        "KingsLand",
                        "10",
                        "Rue du Succes",
                        10),
                        "0458975645",
                        "pascalis.leboss@gmail.com"),
                Role.ADMIN));
    }

    public User addUser(User user){
        userList.add(user);
        return user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUserById(int id){
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow();
    }
}
