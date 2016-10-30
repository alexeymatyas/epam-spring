package com.epam.springadv.ws.schema;

import com.epam.springadv.model.entities.Event;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
@XmlRootElement
public class GetMovieScheduleResponse {
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
