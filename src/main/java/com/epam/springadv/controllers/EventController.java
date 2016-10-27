package com.epam.springadv.controllers;

import com.epam.springadv.model.InsufficientAccountBalanceException;
import com.epam.springadv.model.entities.Event;
import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.services.BookingFacade;
import com.epam.springadv.model.services.BookingService;
import com.epam.springadv.model.services.EventService;
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
    EventService eventService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingFacade bookingFacade;

    @RequestMapping("movies")
    public String listMovies(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("movies", eventService.getAllMovies());

        return "movies";
    }

    @RequestMapping("movies/{movieId}")
    public String listMovieEvents(@ModelAttribute("model") ModelMap model, @PathVariable Long movieId) {
        model.addAttribute("events", eventService.getByMovieId(movieId));

        return "movie-events";
    }

    @RequestMapping("{eventId}/bookings")
    public String listEventBookings(@ModelAttribute("model") ModelMap model, @PathVariable Long eventId) {
        model.addAttribute("bookings", bookingService.getBookingsForEvent(eventId));

        return "event-bookings";
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
