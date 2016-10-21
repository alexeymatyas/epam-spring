package com.epam.springadv.business.discount;

import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Created by Alexey on 20.10.2016.
 */
public class BirthdayStrategy extends DiscountStrategy {
    public BirthdayStrategy(BigDecimal discount) {
        super(discount);
    }

    @Override
    public BigDecimal getDiscount(User user, Event event) {
        LocalDate birthdate = user.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate eventdate = event.getScheduledTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return birthdate.getMonth().equals(eventdate.getMonth())
                && birthdate.getDayOfMonth() == eventdate.getDayOfMonth() ? discount : BigDecimal.ZERO;
    }
}
