package com.epam.springadv.dao;

import com.epam.springadv.model.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Alexey on 17.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldInsert() {
        Movie movie = new Movie();
        movie.setTitle("Forrest Gump");
        movieRepository.save(movie);

        Movie fetchedMovie = movieRepository.findOne(movie.getId());
        Assert.assertTrue(fetchedMovie.getTitle().equals(movie.getTitle()));
    }
}
