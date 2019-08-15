package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.cache.repositories;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCacheRepository implements RedisRepository {

    @Autowired
    private RedisTemplate<String, Object> userDAOTemplate;

    @Override
    public Object getObjectByUUID(String UUID) {

        return userDAOTemplate.opsForList().index(UUID, 0L);
    }

    @Override
    public String saveObjectByUUID(Object object) {
        UserDAO userDAO = UserDAO.class.cast(object);
        userDAOTemplate.opsForList().leftPush(userDAO.getUuid(), userDAO);
        return userDAO.getUuid();
    }

    @Override
    public void deleteObjectByUUID(String UUID) {
        userDAOTemplate.opsForList().leftPop(UUID);
    }
}
