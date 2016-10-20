package com.epam.springadv.business.discount;

import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;

import java.math.BigDecimal;

/**
 * Created by Alexey on 20.10.2016.
 */
public class BirthdayStrategy extends DiscountStrategy {
    public BirthdayStrategy(BigDecimal discount) {
        super(discount);
    }

    @Override
    public BigDecimal getDiscount(User user, Event event) {
        return user.getBirthday().equals(event.getScheduledTime()) ? discount : BigDecimal.ZERO;
    }
}
