package com.epam.springadv.model.dao;

import com.epam.springadv.model.entities.Auditorium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 16.10.2016.
 */
@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
}
