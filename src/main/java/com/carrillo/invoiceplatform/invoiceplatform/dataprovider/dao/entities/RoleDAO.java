package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class RoleDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
