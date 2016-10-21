package com.epam.springadv.services.impl;

import com.epam.springadv.dao.UserRepository;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.services.BookingFacade;
import com.epam.springadv.services.UserService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alexey on 21.10.2016.
 */
@Service
public class BookingFacadeImpl implements BookingFacade {
    @Autowired
    UserRepository userRepository;

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
}
