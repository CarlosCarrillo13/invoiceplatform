package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "bills")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateOfBilling;

    private BigInteger total;

    private String additional;

    private static final long serialVersionUID = 1L;

}
