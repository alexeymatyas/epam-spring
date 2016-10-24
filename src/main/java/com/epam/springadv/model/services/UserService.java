package com.epam.springadv.model.services;

import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.User;

import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface UserService {
    void register(User user);

    void remove(Long userId);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    List<Booking> getBookings(Long userId);
}
