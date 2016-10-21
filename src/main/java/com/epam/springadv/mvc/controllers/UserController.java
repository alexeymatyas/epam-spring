package com.epam.springadv.mvc.controllers;

import com.epam.springadv.model.entities.User;
import com.epam.springadv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("")
    public String listUsers(@ModelAttribute("model") ModelMap model, @RequestParam(value = "email", required = false) String email,
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

    @RequestMapping("{id}")
    public String showUser(@ModelAttribute("model") ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));

        return "user";
    }
}
