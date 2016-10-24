package com.epam.springadv.model.dao;

import com.epam.springadv.model.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByMovieIdAndAuditoriumIdAndScheduledTime(Long movieId, Long auditoriumId, Date scheduledTime);

    List<Event> findByMovieTitle(String movieTitle);

    List<Event> findByMovieId(Long movieId);
}
