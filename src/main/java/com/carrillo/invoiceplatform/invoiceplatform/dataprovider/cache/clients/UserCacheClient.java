package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.cache.clients;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.Client;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.cache.repositories.UserCacheRepository;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.UserDAO;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import com.carrillo.invoiceplatform.invoiceplatform.util.MessageContextItem;
import context.MessageContext;
import exceptions.MessageContextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCacheClient implements Client {

    @Autowired
    UserCacheRepository userCacheRepository;
    @Autowired
    private Mapper<UserDAO, User> userDAOUserMapper;
    @Autowired
    private Mapper<User, UserDAO> userUserDAOMapper;

    @Override
    public void get(MessageContext messageContext) throws MessageContextException {
        String UUID = (String) messageContext.getitem(MessageContextItem.UUID, String.class);
        UserDAO userDAO = (UserDAO) userCacheRepository.getObjectByUUID(UUID);
        if (userDAO != null) {
            messageContext.addItem(MessageContextItem.USER, userDAOUserMapper.map(userDAO));
        }
        else{
            messageContext.addItem(MessageContextItem.USER, new User());
        }
    }

    @Override
    public void getby(MessageContext messageContext) throws MessageContextException {
        //TODO unimplemented
    }

    @Override
    public void save(MessageContext messageContext) throws MessageContextException {
        UserDAO userDAO = userUserDAOMapper.map((User) messageContext.getitem(MessageContextItem.USER, User.class));
        String UUID = userCacheRepository.saveObjectByUUID(userDAO);
    }

    @Override
    public void delete(MessageContext messageContext) throws MessageContextException {
        String UUID = (String) messageContext.getitem(MessageContextItem.UUID, String.class);
        userCacheRepository.deleteObjectByUUID(UUID);
    }
}
