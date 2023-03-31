package com.selfeval.eurder.api.user;

import com.selfeval.eurder.api.user.dto.CustomerDTO;
import com.selfeval.eurder.api.user.dto.DetailedCustomerDTO;
import com.selfeval.eurder.api.user.mappers.UserOutputMapper;
import com.selfeval.eurder.service.user.UserService;
import com.selfeval.eurder.api.user.dto.CreateUserDTO;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.api.user.mappers.UserInputMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{adminId}/customers", produces = "application/json")
    public List<CustomerDTO> getAllCustomers(@PathVariable int adminId){
        return outputMapper.toCustomerDtoList(userService.getAllCustomers(adminId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{adminId}/customers/{customerId}", produces = "application/json")
    public DetailedCustomerDTO getDetailsForACustomer(@PathVariable int adminId, @PathVariable int customerId){
        return outputMapper.toDetailedCustomerDto(userService.getCustomerById(adminId, customerId));
    }
}
