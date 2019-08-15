package com.carrillo.invoiceplatform.invoiceplatform.domain.adapters;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.Client;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.util.MessageContextItem;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class   UserAdapter {

    private final Client userClient;
    private final Client userCacheClient;

    public void getClient(MessageContext messageContext) throws MessageContextException {
        userCacheClient.get(messageContext);
        User user = (User) messageContext.getitem(MessageContextItem.USER, User.class);
        if (user.getId() == null) {
            userClient.get(messageContext);
            userCacheClient.save(messageContext);
        }
    }

    public void saveUser(MessageContext messageContext) throws MessageContextException {
        userClient.save(messageContext);
    }

    public void deleteUser(MessageContext messageContext) throws MessageContextException {
        userClient.delete(messageContext);
    }

    public void getUserByEmail(MessageContext messageContext) throws MessageContextException {
        userClient.getby(messageContext);
    }


}
