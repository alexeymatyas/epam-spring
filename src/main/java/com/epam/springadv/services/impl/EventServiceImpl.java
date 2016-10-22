package com.epam.springadv.services.impl;

import com.epam.springadv.dao.EventRepository;
import com.epam.springadv.dao.MovieRepository;
import com.epam.springadv.model.SchedulingException;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.Movie;
import com.epam.springadv.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void create(Movie movie, Auditorium auditorium, Date scheduledTime) throws SchedulingException {
        List<Event> sameTimeEvents = eventRepository.findByMovieIdAndAuditoriumIdAndScheduledTime(movie.getId(), auditorium.getId(), scheduledTime);
        if(sameTimeEvents.size() > 0) {
            throw new SchedulingException();
        }

        Event event = new Event();
        event.setMovie(movie);
        event.setAuditorium(auditorium);
        event.setScheduledTime(scheduledTime);

        eventRepository.save(event);
    }

    @Override
    public void remove(Long eventId) {
        eventRepository.delete(eventId);
    }

    @Override
    public List<Event> getByMovieName(String name) {
        return eventRepository.findByMovieTitle(name);
    }

    @Override
    public List<Event> getByMovieId(Long id) {
        return eventRepository.findByMovieId(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }
}
