package com.selfeval.eurder.domain.user;

import com.selfeval.eurder.domain.user.baseclasses.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public User addUser(User user){
        userList.add(user);
        return user;
    }

    public List<User> getUserList() {
        return userList;
    }
}
