package com.example.webApp.services;

import com.example.webApp.models.MostPopular;
import com.example.webApp.repositories.MostPopularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MostPopularServiceImpl implements MostPopularService{

    private final MostPopularRepository mostPopularRepository;

    @Autowired
    public MostPopularServiceImpl(MostPopularRepository mostPopularRepository){
        this.mostPopularRepository = mostPopularRepository;
    }
    @Override
    public Iterable<MostPopular> findAll() {
        return mostPopularRepository.findAll();
    }

    @Override
    public MostPopular findById(Long id) {
        return mostPopularRepository.findById(id).get();
    }

    @Override
    public MostPopular save(MostPopular mostPopular) {
        return mostPopularRepository.save(mostPopular);
    }

    @Override
    public void deleteById(Long id) {
        mostPopularRepository.deleteById(id);
    }
}
