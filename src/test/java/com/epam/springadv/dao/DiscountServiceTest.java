package com.epam.springadv.dao;

import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.services.BookingService;
import com.epam.springadv.services.DiscountService;
import com.epam.springadv.services.EventService;
import com.epam.springadv.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Alexey on 21.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class DiscountServiceTest {
    @Autowired
    DiscountService discountService;

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Test
    public void shouldGiveDiscountOnBirthday() {
        Date now = new Date();
        Event event = eventService.getByName("Forrest Gump").get(0);
        User user = userService.getUserByEmail("matias.alexey@gmail.com");
        user.setBirthday(now);
        event.setScheduledTime(now);

        Assert.assertTrue(discountService.getDiscount(user, event).compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    public void shouldGiveDiscountOnNTicket() {
        Event event = eventService.getByName("Forrest Gump").get(0);
        User user = userService.getUserByEmail("matias.alexey@gmail.com");

        for(int i=0; i<9; i++) {
            bookingService.bookTicket(event, Arrays.asList(1), user);
        }

        Assert.assertTrue(discountService.getDiscount(user, event).compareTo(BigDecimal.ZERO) > 0);
    }
}
