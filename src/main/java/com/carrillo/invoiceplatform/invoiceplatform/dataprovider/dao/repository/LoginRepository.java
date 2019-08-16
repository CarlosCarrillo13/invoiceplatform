package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.repository;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.LoginDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDAO, Long> {
    LoginDAO findByUsername(String username);
}
