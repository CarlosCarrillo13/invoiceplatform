package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.mapper;

import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.UserDTO;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDTOUserMapper implements Mapper<UserDTO, User> {
    @Override
    public User map(UserDTO input) {

        User user = new User();
        user.setUUID(UUID.randomUUID().toString());
        user.setName(input.getName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());

        return user;
    }
}
