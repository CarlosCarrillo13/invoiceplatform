package com.carrillo.invoiceplatform.invoiceplatform.dataprovider;

import context.MessageContext;
import exceptions.MessageContextException;

public interface Client {

    void get(MessageContext messageContext) throws MessageContextException;
    void getby(MessageContext messageContext) throws MessageContextException;
    void save(MessageContext messageContext) throws MessageContextException;
    void delete(MessageContext messageContext) throws MessageContextException;
}
