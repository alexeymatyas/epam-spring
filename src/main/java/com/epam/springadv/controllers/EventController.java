package com.epam.springadv.controllers;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.entities.Booking;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.services.BookingFacade;
import com.epam.springadv.model.services.BookingService;
import com.epam.springadv.model.services.EventService;
import com.epam.springadv.rest.BookTicketsRequest;
import com.epam.springadv.rest.BookTicketsResponse;
import com.epam.springadv.restclient.MovieTheaterRestService;
import com.epam.springadv.wsclient.MovieTheaterWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexey on 21.10.2016.
 */
@Controller
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private MovieTheaterWebService movieTheaterWebService;

    @Autowired
    private MovieTheaterRestService movieTheaterRestService;

    @RequestMapping("movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", eventService.getAllMovies());

        return "movies";
    }

    @RequestMapping("movies-ws")
    public String listMoviesThroughWs(Model model) {
        model.addAttribute("movies", movieTheaterWebService.getMovies());

        return "movies";
    }

    @RequestMapping("movies/{movieId}")
    public String listMovieEvents(Model model, @PathVariable Long movieId) {
        model.addAttribute("events", eventService.getByMovieId(movieId));

        return "movie-events";
    }

    @RequestMapping("movies-ws/{movieId}")
    public String listMovieEventsThroughWs(Model model, @PathVariable Long movieId) {
        model.addAttribute("events", movieTheaterWebService.getMovieSchedule(movieId));

        return "movie-events";
    }

    @RequestMapping(value = "{eventId}/bookings", method = RequestMethod.GET)
    public String listEventBookings(Model model, @PathVariable Long eventId) {
        model.addAttribute("bookings", bookingService.getBookingsForEvent(eventId));

        return "event-bookings";
    }

    @RequestMapping(value = "{eventId}/bookings-rest", method = RequestMethod.GET)
    public String listEventBookingsThroughRest(Model model, @PathVariable Long eventId) {
        model.addAttribute("bookings", movieTheaterRestService.getEventBookings(eventId));

        return "event-bookings";
    }

    @RequestMapping(value = "rest/{eventId}/bookings", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> listEventBookings(@PathVariable Long eventId) {
        return bookingService.getBookingsForEvent(eventId);
    }

    @GetMapping("{eventId}/booking")
    public String showEventBookingForm(Model model, @PathVariable Long eventId) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        return "event-booking";
    }

    @RequestMapping(value = "{eventId}/book-tickets", params = {"seats"})
    public String bookTickets(@PathVariable Long eventId, @RequestParam String seats, Authentication auth,
                              RedirectAttributes redirectAttributes) {
        Event event = eventService.getById(eventId);
        try {
            List<Integer> seatNumbers = new ArrayList<>();
            for(String seat: seats.split(", ")) {
                seatNumbers.add(Integer.parseInt(seat));
            }
            bookingFacade.bookTickets(event, seatNumbers, (User) auth.getPrincipal());
            redirectAttributes.addFlashAttribute("message", "Successfully booked");
        } catch (InsufficientAccountBalanceException e) {
            redirectAttributes.addFlashAttribute("message", "Not enough money!");
        }

        return "redirect:/events/" + event.getId() + "/booking";
    }

    @RequestMapping(value = "rest/{eventId}/booking", method = RequestMethod.POST)
    @ResponseBody
    public BookTicketsResponse bookTickets(@RequestBody BookTicketsRequest request, Authentication auth) {
        BookTicketsResponse response = new BookTicketsResponse();
        Event event = eventService.getById(request.getEventId());
        try {
            List<Integer> seatNumbers = new ArrayList<>();
            for(Integer seat: request.getSeats()) {
                seatNumbers.add(seat);
            }
            bookingFacade.bookTickets(event, seatNumbers, (User) auth.getPrincipal());
            response.setStatus("ok");
        } catch (InsufficientAccountBalanceException e) {
            response.setStatus("error");
            response.setErrorMessage("Not enough money!");
        }

        return response;
    }

    @GetMapping("upload")
    public String showUploadForm() {
        return "events-upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) throws Exception {
        bookingFacade.uploadEvents(file.getInputStream());
        redirectAttributes.addFlashAttribute("message", "Success");

        return "redirect:/events/movies";
    }
}
