package com.movierec.model;

import org.hibernate.type.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private BigDecimal amount;
    private UserDetails user;


    public Payment(LocalDateTime paymentDate, CurrencyType currencyType, BigDecimal amount) {
        super();
        this.paymentDate = paymentDate;
        this.currencyType = currencyType;
        this.amount = amount;
    }

}
