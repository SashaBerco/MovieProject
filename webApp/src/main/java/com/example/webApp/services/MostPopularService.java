package com.example.webApp.services;

import com.example.webApp.models.MostPopular;


public interface MostPopularService {

    Iterable<MostPopular> findAll();

    MostPopular findById(Long id);

    MostPopular save(MostPopular mostPopular);

    void deleteById(Long id);
}
