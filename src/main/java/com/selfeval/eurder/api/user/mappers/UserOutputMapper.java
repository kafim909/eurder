package com.selfeval.eurder.api.user.mappers;

import com.selfeval.eurder.api.user.dto.CustomerDTO;
import com.selfeval.eurder.api.user.dto.DetailedCustomerDTO;
import com.selfeval.eurder.api.user.dto.UserMinimumDataDTO;
import com.selfeval.eurder.domain.user.baseclasses.Contact;
import com.selfeval.eurder.domain.user.baseclasses.Name;
import com.selfeval.eurder.domain.user.baseclasses.User;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserOutputMapper {

    public UserMinimumDataDTO toMinimumDataDto(User user) {
        return new UserMinimumDataDTO(
                new Name(user.getName()),
                user.getRole(),
                user.getId()
        );
    }

    public CustomerDTO customerDTO(User user){
        return new CustomerDTO(
                user.getId(),
                new Name(user.getName()),
                user.getRole());
    }

    public List<CustomerDTO> toCustomerDtoList(List<User> allCustomers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        allCustomers.forEach(user -> customerDTOList.add(customerDTO(user)));
        return customerDTOList;
    }

    public DetailedCustomerDTO toDetailedCustomerDto(User user) {
        return new DetailedCustomerDTO(
                user.getId(),
                new Name(user.getName()),
                new Contact(user.getContact()),
                user.getRole());
    }
}
