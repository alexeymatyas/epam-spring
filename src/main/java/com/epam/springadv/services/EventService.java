package com.epam.springadv.services;

import com.epam.springadv.model.SchedulingException;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.Movie;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface EventService {
    void create(Movie movie, Auditorium auditorium, Date scheduledTime) throws SchedulingException;

    void remove(Long eventId);

    List<Event> getByName(String name);

    List<Event> getAll();
}
