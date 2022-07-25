package com.movierec.controller;

import com.movierec.model.Movie;
import com.movierec.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping(value = "/{id}")
    public Movie addMovie(@RequestBody Movie movie, @PathVariable long id) {
        return movieService.addMovie(movie,id);
    }

    @GetMapping(value = "/all")
    public Iterable<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Iterable<Movie> findById(@PathVariable long id) {
        return movieService.findById(id);
    }
}
