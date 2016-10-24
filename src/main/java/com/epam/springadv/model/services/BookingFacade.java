package com.epam.springadv.model.services;

import com.epam.springadv.model.SchedulingException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alexey on 21.10.2016.
 */
public interface BookingFacade {
    void uploadUsers(InputStream stream) throws IOException;

    void uploadEvents(InputStream stream) throws IOException, SchedulingException;
}
