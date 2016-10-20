package com.epam.springadv.business.discount;

import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;

import java.math.BigDecimal;

/**
 * Created by Alexey on 20.10.2016.
 */
public abstract class DiscountStrategy {
    protected BigDecimal discount;

    public DiscountStrategy(BigDecimal discount) {
        this.discount = discount;
    }

    public abstract BigDecimal getDiscount(User user, Event event);

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
