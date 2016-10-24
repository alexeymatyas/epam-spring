package com.epam.springadv.model.services;

import com.epam.springadv.model.entities.Auditorium;

import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface AuditoriumService {
    List<Auditorium> getAuditoriums();

    int getSeatsNumber(Long auditoriumId);

    String getVipSeats(Long auditoriumId);
}
