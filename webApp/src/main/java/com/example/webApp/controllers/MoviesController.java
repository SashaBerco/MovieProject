package com.example.webApp.controllers;

import com.example.webApp.models.Movie;
import com.example.webApp.repositories.MovieRepository;
import com.example.webApp.services.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MoviesController {
    @Autowired
    public MoviesController(MoviesServiceImpl moviesServiceImpl) {
        this.moviesServiceImpl = moviesServiceImpl;
    }


    private final MoviesServiceImpl moviesServiceImpl;

    @GetMapping("/movie")
    public String allMovie(Model model) {
        Iterable<Movie> movie = moviesServiceImpl.findAll();
        model.addAttribute("movie", movie);
        return "movies";
    }

    @GetMapping("/movie/add")
    public String addMovie(Model model ) {
        return "add";
    }

    @PostMapping("/movie/add")
    public String postMovie(@RequestParam String title, @RequestParam String description, Model model){
        Movie movie = new Movie(title,description);
        moviesServiceImpl.save(movie);
        return "redirect:/movie";
    }

    @GetMapping("/movie/{id}")
    public String detailsMovie(Model model, @PathVariable(value = "id") long id) {
        Movie movie = moviesServiceImpl.findById(id);
        model.addAttribute("movie", movie);
        return "details";
    }

    @GetMapping("/movie/{id}/edit")
    public String editMovie(Model model, @PathVariable(value = "id") long id) {
        Movie movie = moviesServiceImpl.findById(id);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }
    @PostMapping("/movie/{id}/edit")
    public String updateMovie(@PathVariable(value = "id") long id, @ModelAttribute Movie mv) {
        Movie movie = moviesServiceImpl.findById(id);
        movie.setTitle(mv.getTitle());
        movie.setDescription(mv.getDescription());
        moviesServiceImpl.save(mv);
        return "redirect:/movie";
    }
    @PostMapping("/movie/{id}/remove")
    public String detailsMovie(@PathVariable(value = "id") long id, Model model ) {
        moviesServiceImpl.deleteById(id);
        return "redirect:/movie";
    }
}
