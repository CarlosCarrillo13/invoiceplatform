package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    @Email
    private String email;

    private String uuid;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private List<BillDAO> bills;

    private static final long serialVersionUID =1L;

}
