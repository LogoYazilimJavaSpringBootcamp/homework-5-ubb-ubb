package com.movierec.repository;

import com.movierec.model.Movie;
import com.movierec.model.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    Iterable<Movie> findById(long id);
    List<Movie> findMoviesByUser(UserDetails userDetails);

}
