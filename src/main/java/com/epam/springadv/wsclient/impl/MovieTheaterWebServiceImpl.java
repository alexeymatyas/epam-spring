package com.epam.springadv.wsclient.impl;

import com.epam.springadv.wsclient.MovieTheaterWebService;
import com.epam.springadv.wsclient.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
@Service
public class MovieTheaterWebServiceImpl implements MovieTheaterWebService {
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Override
    public List<Movie> getMovies() {
        GetMoviesRequest request = new GetMoviesRequest();

        GetMoviesResponse response = (GetMoviesResponse) webServiceTemplate.marshalSendAndReceive(request);
        return response.getMovies();
    }

    @Override
    public List<Event> getMovieSchedule(Long movieId) {
        GetMovieScheduleRequest request = new GetMovieScheduleRequest();
        request.setMovieId(movieId);

        GetMovieScheduleResponse response = (GetMovieScheduleResponse) webServiceTemplate.marshalSendAndReceive(request);
        return response.getEvents();
    }

    @Override
    public List<User> getUsers() {
        GetUsersRequest request = new GetUsersRequest();

        GetUsersResponse response = (GetUsersResponse) webServiceTemplate.marshalSendAndReceive(request);
        return response.getUsers();
    }
}
