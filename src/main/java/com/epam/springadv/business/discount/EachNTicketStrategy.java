package com.epam.springadv.business.discount;

import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alexey on 20.10.2016.
 */
public class EachNTicketStrategy extends DiscountStrategy {
    int freeTicketNumber;

    @Autowired
    UserService userService;

    public EachNTicketStrategy(BigDecimal discount, int freeTicketNumber) {
        super(discount);
        this.freeTicketNumber = freeTicketNumber;
    }

    @Override
    public BigDecimal getDiscount(User user, Event event) {
        List<Booking> userBookings = userService.getBookings(user.getId());
        return !userBookings.isEmpty() && ((userBookings.size()+1) % freeTicketNumber == 0) ? discount : BigDecimal.ZERO;
    }
}
