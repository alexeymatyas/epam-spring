package com.epam.springadv.dao;

import com.epam.springadv.model.Rating;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 17.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class EventRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void shouldInsert() {
        Movie movie = new Movie();
        movie.setTitle("Catch me if you can");
        movie.setRating(Rating.HIGH);
        movie.setBasePrice(BigDecimal.valueOf(100.50));
        movieRepository.save(movie);

        Auditorium mainAuditorium = auditoriumRepository.findOne(1L);

        Event event = new Event();
        event.setMovie(movie);
        event.setAuditorium(mainAuditorium);
        event.setScheduleTime(new Date());

        eventRepository.save(event);

        Event fetchedEvent = eventRepository.findOne(event.getId());

        Assert.assertTrue(fetchedEvent != null);
    }
}
