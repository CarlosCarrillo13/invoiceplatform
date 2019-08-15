package com.carrillo.invoiceplatform.invoiceplatform.domain.handlers;

import com.carrillo.invoiceplatform.invoiceplatform.domain.adapters.UserAdapter;
import context.MessageContext;
import exceptions.MessageContextException;
import handlers.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("saveUserHandler")
@RequiredArgsConstructor
public class SaveUserHandler implements Handler {

    private final UserAdapter userAdapter;
    @Override
    public void execute(MessageContext messageContext) throws MessageContextException {
        userAdapter.saveUser(messageContext);
    }
}
