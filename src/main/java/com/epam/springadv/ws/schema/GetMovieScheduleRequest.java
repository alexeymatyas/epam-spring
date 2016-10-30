package com.epam.springadv.ws.schema;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alexey on 30.10.2016.
 */
@XmlRootElement
public class GetMovieScheduleRequest {
    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
