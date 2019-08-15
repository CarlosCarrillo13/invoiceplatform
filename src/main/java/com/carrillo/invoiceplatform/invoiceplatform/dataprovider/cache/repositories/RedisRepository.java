package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.cache.repositories;

public interface RedisRepository {

    Object getObjectByUUID(String UUID);
    String saveObjectByUUID(Object object);
    void deleteObjectByUUID(String UUID);

}
