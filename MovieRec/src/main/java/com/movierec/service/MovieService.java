package com.movierec.service;

import com.movierec.model.Movie;
import com.movierec.model.Status;
import com.movierec.model.UserDetails;
import com.movierec.repository.MovieRepository;
import com.movierec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public Movie addMovie(Movie movie, long id) {


        UserDetails user = userRepository.findById(id).get();

        if (user.getStatus()  == Status.FREE && user.getRemaining().intValue() > 0) {

            user.setRemaining(user.getRemaining()-1);

            movie.setUser(user);
            return movieRepository.save(movie);

        }
        else if (user.getStatus()  == Status.PAID) {


            movie.setUser(user);
            return movieRepository.save(movie);

        }

        else if(user.getStatus()  == Status.FREE && user.getRemaining().intValue() <= 0) {

            System.out.println("Free Subscription limit reached.");
            return movie;
        }

        return movieRepository.save(movie);
    }

    public Iterable<Movie> findAll() {

        return movieRepository.findAll();
    }

    public Iterable<Movie> findById(long id) {

        UserDetails user = userRepository.findById(id).get();

        return movieRepository.findMoviesByUser(user);
    }
}
