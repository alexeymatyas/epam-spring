package com.epam.springadv.model.services;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface BookingService {
    BigDecimal getTicketPrice(Event event, List<Integer> seats, User user);

    void bookTickets(Event event, List<Integer> seats, User user) throws InsufficientAccountBalanceException;

    List<Booking> getBookingsForEvent(Long eventId);
}
