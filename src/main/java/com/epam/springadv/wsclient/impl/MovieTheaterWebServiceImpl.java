package com.epam.springadv.wsclient.impl;

import com.epam.springadv.wsclient.MovieTheaterWebService;
import com.epam.springadv.wsclient.schema.GetMoviesRequest;
import com.epam.springadv.wsclient.schema.GetMoviesResponse;
import com.epam.springadv.wsclient.schema.Movie;
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

        GetMoviesResponse response = (GetMoviesResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws", request);
        return response.getMovies();
    }
}
