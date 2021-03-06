package com.epam.springadv.controllers;

import com.epam.springadv.model.entities.User;
import com.epam.springadv.model.services.BookingFacade;
import com.epam.springadv.model.services.UserService;
import com.epam.springadv.wsclient.MovieTheaterWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexey on 21.10.2016.
 */
@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BookingFacade bookingFacade;

    @Autowired
    MovieTheaterWebService movieTheaterWebService;

    @RequestMapping("")
    public String listUsers(Model model, @RequestParam(value = "email", required = false) String email,
                            @RequestParam(value = "name", required = false) String name) {
        List<User> users = null;
        if(email != null) {
            User user = userService.getUserByEmail(email);
            if(user != null) {
                users = Arrays.asList(user);
            }
        } else if(name != null) {
            users = userService.getUsersByName(name);
        } else {
            users = userService.getAllUsers();
        }

        model.addAttribute("users", users);

        return "users";
    }

    @RequestMapping("ws")
    public String listUsersThroughWs(Model model) {
        model.addAttribute("users", movieTheaterWebService.getUsers());

        return "users";
    }

    @RequestMapping("{id}")
    public String showUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));

        return "user";
    }

    @RequestMapping(value = "{userId}/bookings")
    public String showUserBookings(Model model, @PathVariable Long userId) {
        model.addAttribute("bookings", userService.getBookings(userId));

        return "user-bookings";
    }

    @PostMapping(value = "{userId}/refill-account", params = {"refillAmount"})
    public String refillUserAccount(@PathVariable Long userId, @RequestParam BigDecimal refillAmount) {
        bookingFacade.refillUserAccount(userId, refillAmount);

        return "redirect:/users/" + userId;
    }

    @GetMapping("upload")
    public String showUploadForm() {
        return "users-upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) throws Exception {
        bookingFacade.uploadUsers(file.getInputStream());
        redirectAttributes.addFlashAttribute("message", "Success");

        return "redirect:/users";
    }
}
