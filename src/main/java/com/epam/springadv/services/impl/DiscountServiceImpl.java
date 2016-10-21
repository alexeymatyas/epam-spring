package com.epam.springadv.services.impl;

import com.epam.springadv.business.discount.DiscountStrategy;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.services.DiscountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alexey on 20.10.2016.
 */
public class DiscountServiceImpl implements DiscountService {
    List<DiscountStrategy> discountStrategies;

    public DiscountServiceImpl(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    @Override
    public BigDecimal getDiscount(User user, Event event) {
        return discountStrategies.stream().max((o1, o2) ->
                o1.getDiscount(user, event).compareTo(o2.getDiscount(user, event))).get().getDiscount(user, event);
    }

    public List<DiscountStrategy> getDiscountStrategies() {
        return discountStrategies;
    }

    public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }
}
