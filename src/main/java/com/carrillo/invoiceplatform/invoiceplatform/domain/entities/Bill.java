package com.carrillo.invoiceplatform.invoiceplatform.domain.entities;

import java.math.BigInteger;
import java.util.Date;

public class Bill {

    private Long id;

    private Date dateOfBilling;

    private BigInteger total;

    private String additional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBilling() {
        return dateOfBilling;
    }

    public void setDateOfBilling(Date dateOfBilling) {
        this.dateOfBilling = dateOfBilling;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
