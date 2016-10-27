package com.epam.springadv.model.services.impl;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.dao.UserAccountRepository;
import com.epam.springadv.model.entities.UserAccount;
import com.epam.springadv.model.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Alexey on 26.10.2016.
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public void chargeUserAccount(Long userId, BigDecimal amount) throws InsufficientAccountBalanceException {
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Charging amount should be greater than 0");
        }

        UserAccount account = userAccountRepository.findByUserId(userId);
        if(account == null) {
            throw new RuntimeException("No account found for user id " + userId);
        }

        BigDecimal newBalance = account.getBalance().subtract(amount);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientAccountBalanceException();
        }

        account.setBalance(newBalance);
        userAccountRepository.save(account);
    }

    @Override
    public void refillUserAccount(Long userId, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Refilling amount should be greater than 0");
        }

        UserAccount account = userAccountRepository.findByUserId(userId);
        if(account == null) {
            throw new RuntimeException("No account found for user id " + userId);
        }

        BigDecimal newBalance = account.getBalance().add(amount);

        account.setBalance(newBalance);
        userAccountRepository.save(account);
    }
}
