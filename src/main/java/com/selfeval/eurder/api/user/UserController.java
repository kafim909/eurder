package com.selfeval.eurder.api.user;

import com.selfeval.eurder.service.user.UserService;
import com.selfeval.eurder.service.user.dto.CreateUserDTO;
import com.selfeval.eurder.service.user.dto.UserDTO;
import com.selfeval.eurder.service.user.mappers.UserInputMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    private final UserInputMapper inputMapper;

    public UserController(UserService userService, UserInputMapper inputMapper) {
        this.userService = userService;
        this.inputMapper = inputMapper;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO){
        return userService.createUser(inputMapper.fromCreateUserDtoToUser(createUserDTO));
    }
}
