package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.clients;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.Client;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.UserDAO;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.repository.UserRepository;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import com.carrillo.invoiceplatform.invoiceplatform.util.MessageContextItem;
import com.carrillo.invoiceplatform.invoiceplatform.util.constants.QueryConstants;
import context.MessageContext;
import exceptions.MessageContextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserClient implements Client {

    @Autowired
    private Mapper<UserDAO, User> userDAOUserMapper;
    @Autowired
    private Mapper<User, UserDAO> userUserDAOMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void get(MessageContext messageContext) throws MessageContextException {

        String UUID = (String) messageContext.getitem(MessageContextItem.UUID, String.class);
        Optional<UserDAO> user = Optional.ofNullable(userRepository.findByUuid(UUID)).orElse(null);
        messageContext.addItem(MessageContextItem.USER, userDAOUserMapper.map(user.get()));
    }


    @Override
    public void getby(MessageContext messageContext) throws MessageContextException {

        Optional<UserDAO> user = null;
        String value = (String) messageContext.getitem(MessageContextItem.QUERY, String.class);
        if (value.equalsIgnoreCase(QueryConstants.EMAIL)) {
            user = Optional.ofNullable(userRepository.findByEmail(value)).orElse(null);
        }
        messageContext.addItem(MessageContextItem.USER, user != null ? userDAOUserMapper.map(user.get()) : new User());
    }

    @Override
    public void save(MessageContext messageContext) throws MessageContextException {
        UserDAO userDAO = userUserDAOMapper.map((User)messageContext.getitem(MessageContextItem.USER, User.class));
        userRepository.save(userDAO);
    }

    @Override
    public void delete(MessageContext messageContext) throws MessageContextException {
        Long id = (Long)messageContext.getitem(MessageContextItem.ID, Long.class);
        userRepository.deleteById(id);
    }
}
