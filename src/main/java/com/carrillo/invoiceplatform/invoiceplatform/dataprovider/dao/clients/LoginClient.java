package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.clients;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.LoginDAO;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LoginClient implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginDAO loginDAO = loginRepository.findByUsername(username);

        if (loginDAO == null){
            throw new UsernameNotFoundException(String.format("el usuario %s no fue encontrado",  username));
        }

        List<GrantedAuthority> authorities = loginDAO.getRoles()
                .stream().map( roleDAO -> new SimpleGrantedAuthority(roleDAO.getName()))
                .peek(authority -> log.info(authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(loginDAO.getUsername(), loginDAO.getPassword(), loginDAO.getEnabled(),
                loginDAO.getAccountNotExpired(), loginDAO.getCredentialsNotExpired(),
                loginDAO.getAccountNotLocked(), authorities);
    }
}
