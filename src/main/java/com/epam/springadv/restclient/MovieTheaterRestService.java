package com.epam.springadv.restclient;

import com.epam.springadv.model.entities.Booking;

import java.util.List;

/**
 * Created by Alexey on 31.10.2016.
 */
public interface MovieTheaterRestService {
    List<Booking> getEventBookings(Long eventId);
}
