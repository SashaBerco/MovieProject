package com.example.webApp.services;

import com.example.webApp.models.Movie;


public interface MoviesServices {

    Iterable<Movie> findAll();

    Movie findById(Long id);

    Movie save(Movie movie);

    void deleteById(Long id);

}
