package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


@Data
@Builder
public class BillDTO {

    private Long id;

    private Date dateOfBilling;

    private BigInteger total;

    private String additional;
}
