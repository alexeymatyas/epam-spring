package com.epam.springadv.model.services;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.SchedulingException;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alexey on 21.10.2016.
 */
public interface BookingFacade {
    void uploadUsers(InputStream stream) throws IOException;

    void uploadEvents(InputStream stream) throws IOException, SchedulingException;

    void refillUserAccount(Long userId, BigDecimal amount);

    void bookTickets(Event event, List<Integer> seats, User user) throws InsufficientAccountBalanceException;
}
