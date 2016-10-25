package com.epam.springadv.controllers;

import com.epam.springadv.model.services.BookingFacade;
import com.epam.springadv.model.services.BookingService;
import com.epam.springadv.model.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
