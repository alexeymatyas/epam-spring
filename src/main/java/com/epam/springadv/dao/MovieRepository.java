package com.epam.springadv.dao;

import com.epam.springadv.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 16.10.2016.
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
