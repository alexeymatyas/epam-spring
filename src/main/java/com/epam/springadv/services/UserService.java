package com.epam.springadv.services;

import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.User;

import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface UserService {
    void register(User user);

    void remove(Long userId);

    User getUserById(Long id);

    User getUserByEmail(String email);

    User getUserByName(String name);

    List<Booking> getBookings(Long userId);
}
