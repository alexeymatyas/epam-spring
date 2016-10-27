package com.epam.springadv.model.services;

import com.epam.springadv.model.InsufficientAccountBalanceException;

import java.math.BigDecimal;

/**
 * Created by Alexey on 26.10.2016.
 */
public interface UserAccountService {
    void chargeUserAccount(Long userId, BigDecimal amount) throws InsufficientAccountBalanceException;

    void refillUserAccount(Long userId, BigDecimal amount);
}
