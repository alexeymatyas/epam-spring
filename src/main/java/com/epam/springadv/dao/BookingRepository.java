package com.epam.springadv.dao;

import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexey on 16.10.2016.
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    List<Booking> findByEventId(Long eventId);
}
