package com.epam.springadv.model.dao;

import com.epam.springadv.model.Rating;
import com.epam.springadv.model.entities.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * Created by Alexey on 17.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config/application-context.xml")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldInsert() {
        Movie movie = new Movie();
        movie.setTitle("Forrest Gump");
        movie.setRating(Rating.HIGH);
        movie.setBasePrice(BigDecimal.valueOf(550.55));
        movieRepository.save(movie);

        Movie fetchedMovie = movieRepository.findOne(movie.getId());
        Assert.assertTrue(fetchedMovie.getTitle().equals(movie.getTitle()));
    }
}
