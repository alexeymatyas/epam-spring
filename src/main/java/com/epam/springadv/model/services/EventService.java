package com.epam.springadv.model.services;

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
    Event getById(Long eventId);

    void create(Movie movie, Auditorium auditorium, Date scheduledTime) throws SchedulingException;

    void remove(Long eventId);

    List<Event> getByMovieName(String name);

    List<Event> getByMovieId(Long id);

    List<Movie> getAllMovies();

    List<Event> getAllEvents();
}
