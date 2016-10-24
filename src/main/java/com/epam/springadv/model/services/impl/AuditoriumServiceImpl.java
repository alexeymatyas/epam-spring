package com.epam.springadv.model.services.impl;

import com.epam.springadv.model.dao.AuditoriumRepository;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alexey on 20.10.2016.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Override
    public List<Auditorium> getAuditoriums() {
        return (List<Auditorium>) auditoriumRepository.findAll();
    }

    @Override
    public int getSeatsNumber(Long auditoriumId) {
        return auditoriumRepository.findOne(auditoriumId).getSeatsNumber();
    }

    @Override
    public String getVipSeats(Long auditoriumId) {
        return auditoriumRepository.findOne(auditoriumId).getVipSeats();
    }
}
