package com.carrillo.invoiceplatform.invoiceplatform.util;

public interface Mapper<I, O> {

    O map (I input);
}
