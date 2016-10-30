package com.epam.springadv.restclient.impl;

import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.restclient.MovieTheaterRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by Alexey on 31.10.2016.
 */
@Service
public class MovieTheaterRestServiceImpl implements MovieTheaterRestService {
    private static final RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Booking> getEventBookings(Long eventId) {
        Map<String, Long> vars = new HashMap<String, Long>();
        vars.put("eventId", eventId);

        String plainCreds = "manager1@gmail.com:qwe123";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + base64Creds);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<Booking[]> responseEntity = restTemplate.exchange(
                "http://localhost:8080/events/rest/{eventId}/bookings",
                HttpMethod.GET, entity, Booking[].class, vars);

        Booking[] bookings = responseEntity.getBody();
        return new ArrayList<>(Arrays.asList(bookings));
    }
}
