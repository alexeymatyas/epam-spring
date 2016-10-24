package com.epam.springadv.model.services.impl;

import com.epam.springadv.model.dao.AuditoriumRepository;
import com.epam.springadv.model.dao.MovieRepository;
import com.epam.springadv.model.dao.UserRepository;
import com.epam.springadv.model.SchedulingException;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.Movie;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.json.MovieDeserializer;
import com.epam.springadv.model.services.BookingFacade;
import com.epam.springadv.model.services.EventService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexey on 21.10.2016.
 */
@Service
public class BookingFacadeImpl implements BookingFacade {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    EventService eventService;

    @Override
    public void uploadUsers(InputStream stream) throws IOException {
        JsonFactory f = new JsonFactory();
        JsonParser jp = f.createParser(stream);
        ObjectMapper mapper = new ObjectMapper();

        jp.nextToken();
        while (jp.nextToken() == JsonToken.START_OBJECT) {
            User user = mapper.readValue(jp, User.class);
            userRepository.save(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void uploadEvents(InputStream stream) throws IOException, SchedulingException {
        List<Auditorium> auditoriumList = (List<Auditorium>) auditoriumRepository.findAll();
        Map<Long, Auditorium> auditoriumMap = new HashMap<>();
        for(Auditorium auditorium: auditoriumList) {
            auditoriumMap.put(auditorium.getId(), auditorium);
        }

        JsonFactory f = new JsonFactory();
        JsonParser jp = f.createParser(stream);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Movie.class, new MovieDeserializer(auditoriumMap));
        mapper.registerModule(module);
        jp.setCodec(mapper);

        jp.nextToken();
        while (jp.nextToken() == JsonToken.START_OBJECT) {
            Movie movie = mapper.readValue(jp, Movie.class);
            movieRepository.save(movie);
            for(Event event: movie.getEvents()) {
                eventService.create(movie, event.getAuditorium(), event.getScheduledTime());
            }
        }
    }
}
