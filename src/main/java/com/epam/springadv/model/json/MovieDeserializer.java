package com.epam.springadv.model.json;

import com.epam.springadv.model.Rating;
import com.epam.springadv.model.entities.Auditorium;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.Movie;
import com.epam.springadv.model.entities.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alexey on 22.10.2016.
 */
public class MovieDeserializer extends StdDeserializer<Movie> {
    private Map<Long, Auditorium> auditoriums;

    public MovieDeserializer(Map<Long, Auditorium> auditoriums) {
        super(Movie.class);
        this.auditoriums = auditoriums;
    }

    @Override
    public Movie deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JsonNode node = jp.getCodec().readTree(jp);
        String title = node.get("title").textValue();
        BigDecimal basePrice = BigDecimal.valueOf(node.get("base_price").doubleValue());
        int ratingId = node.get("rating_id").asInt();

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setRating(Rating.values()[ratingId]);
        movie.setBasePrice(basePrice);

        ArrayNode eventsNode = (ArrayNode) node.get("events");
        List<Event> events = new ArrayList<>();
        Iterator<JsonNode> iterator = eventsNode.elements();
        while(iterator.hasNext()) {
            JsonNode eventNode = iterator.next();
            Auditorium auditorium = auditoriums.get(eventNode.get("auditorium_id").asLong());
            Date scheduledTime = null;
            try {
                 scheduledTime = df.parse(eventNode.get("scheduled_time").textValue());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Event event = new Event();
            event.setMovie(movie);
            event.setAuditorium(auditorium);
            event.setScheduledTime(scheduledTime);

            events.add(event);
        }
        movie.setEvents(events);

        return movie;
    }
}
