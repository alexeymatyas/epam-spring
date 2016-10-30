package com.epam.springadv.ws.schema;

import com.epam.springadv.model.entities.Movie;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Alexey on 29.10.2016.
 */
@XmlRootElement
public class GetMoviesResponse {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
