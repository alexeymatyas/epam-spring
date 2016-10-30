package com.epam.springadv.wsclient;

import com.epam.springadv.wsclient.schema.Event;
import com.epam.springadv.wsclient.schema.Movie;
import com.epam.springadv.wsclient.schema.User;

import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
public interface MovieTheaterWebService {
    List<Movie> getMovies();

    List<Event> getMovieSchedule(Long movieId);

    List<User> getUsers();
}
