package com.epam.springadv.dao;

import com.epam.springadv.model.entities.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alexey on 18.10.2016.
 */
public interface EventRepository extends CrudRepository<Event, Long> {
}
