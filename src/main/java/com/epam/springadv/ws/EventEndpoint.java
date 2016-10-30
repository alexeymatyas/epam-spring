package com.epam.springadv.ws;

import com.epam.springadv.model.services.EventService;
import com.epam.springadv.ws.schema.GetMoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Alexey on 29.10.2016.
 */
@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://com.epam.springadv";

    @Autowired
    private EventService eventService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMoviesRequest")
    @ResponsePayload
    public GetMoviesResponse getMovies() {
        GetMoviesResponse response = new GetMoviesResponse();
        response.setMovies(eventService.getAllMovies());

        return response;
    }
}
