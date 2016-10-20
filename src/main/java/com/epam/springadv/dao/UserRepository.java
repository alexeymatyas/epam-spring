package com.epam.springadv.dao;

import com.epam.springadv.model.entities.Movie;
import com.epam.springadv.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 16.10.2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByName(String name);
}
