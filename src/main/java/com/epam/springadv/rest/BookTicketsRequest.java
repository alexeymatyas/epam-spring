package com.epam.springadv.rest;

import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
public class BookTicketsRequest {
    private Long eventId;

    private List<Integer> seats;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }
}
