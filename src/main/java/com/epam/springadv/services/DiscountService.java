package com.epam.springadv.services;

import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;

import java.math.BigDecimal;

/**
 * Created by Alexey on 20.10.2016.
 */
public interface DiscountService {
    BigDecimal getDiscount(User user, Event event);
}
