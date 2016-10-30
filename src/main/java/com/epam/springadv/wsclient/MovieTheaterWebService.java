package com.epam.springadv.wsclient;

import com.epam.springadv.wsclient.schema.Movie;

import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
public interface MovieTheaterWebService {
    List<Movie> getMovies();
}
