package com.epam.springadv.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexey on 17.10.2016.
 */
@Controller
public class MovieController {
    @RequestMapping("movies")
    public String showMovies() {
        return "movies";
    }
}
