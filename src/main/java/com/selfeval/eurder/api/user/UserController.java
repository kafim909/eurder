package com.selfeval.eurder.api.user;

import com.selfeval.eurder.api.user.mappers.UserOutputMapper;
import com.selfeval.eurder.service.user.UserService;
import com.selfeval.eurder.api.user.dto.CreateUserDTO;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.api.user.mappers.UserInputMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    private final UserInputMapper inputMapper;
    private final UserOutputMapper outputMapper;

    public UserController(UserService userService, UserInputMapper inputMapper, UserOutputMapper outputMapper) {
        this.userService = userService;
        this.inputMapper = inputMapper;
        this.outputMapper = outputMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public UserMinimumDataDTO createUser(@RequestBody CreateUserDTO createUserDTO){
        return outputMapper.toMinimumDataDto(
                userService.createUser(
                        inputMapper.mapToUser(createUserDTO)));
    }
}
