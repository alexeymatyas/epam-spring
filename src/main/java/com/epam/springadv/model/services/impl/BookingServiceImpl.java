package com.epam.springadv.model.services.impl;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.dao.BookingRepository;
import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.services.BookingService;
import com.epam.springadv.model.services.DiscountService;
import com.epam.springadv.model.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 20.10.2016.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    DiscountService discountService;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserAccountService userAccountService;

    @Override
    public BigDecimal getTicketPrice(Event event, List<Integer> seats, User user) {
        BigDecimal discount = discountService.getDiscount(user, event);
        return discount.compareTo(BigDecimal.ZERO) > 0 ?
                event.getMovie().getBasePrice().multiply(discount) : event.getMovie().getBasePrice();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = InsufficientAccountBalanceException.class)
    public void bookTickets(Event event, List<Integer> seats, User user) throws InsufficientAccountBalanceException {
        for(Integer seat: seats) {
            BigDecimal ticketPrice = getTicketPrice(event, seats, user);

            userAccountService.chargeUserAccount(user.getId(), ticketPrice);

            Booking booking = new Booking();
            booking.setEvent(event);
            booking.setUser(user);
            booking.setSeatNumber(seat);
            booking.setBookingTime(new Date());
            booking.setPrice(ticketPrice);
            bookingRepository.save(booking);
        }
    }

    @Override
    public List<Booking> getBookingsForEvent(Long eventId) {
        return bookingRepository.findByEventId(eventId);
    }
}
