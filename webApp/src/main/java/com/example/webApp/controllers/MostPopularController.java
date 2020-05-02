package com.example.webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MostPopularController {

    @GetMapping("/mostPopular")
    public String mostPopular(){
        return "mostpopular";
    }
}
