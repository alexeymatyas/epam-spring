package com.epam.springadv.services;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alexey on 21.10.2016.
 */
public interface BookingFacade {
    void uploadUsers(InputStream stream) throws IOException;
}
