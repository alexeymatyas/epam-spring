package com.epam.springadv.services.impl;

import com.epam.springadv.dao.BookingRepository;
import com.epam.springadv.dao.UserRepository;
import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<Booking> getBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
