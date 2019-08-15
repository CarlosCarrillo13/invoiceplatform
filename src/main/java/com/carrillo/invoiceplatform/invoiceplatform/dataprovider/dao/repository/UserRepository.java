package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.repository;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {

    Optional<UserDAO> findByUuid(String UUID);

    Optional<UserDAO> findByEmail(String value);
}
