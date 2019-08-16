package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "logins")
@Data
public class LoginDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean accountNotExpired;

    private Boolean credentialsNotExpired;

    private Boolean accountNotLocked;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "login_roles", joinColumns = @JoinColumn(name = "login_id")
    , inverseJoinColumns = @JoinColumn(name = "role_id")
    , uniqueConstraints = {@UniqueConstraint(columnNames = {"login_id", "role_id"})})
    private List<RoleDAO> roles;
}
