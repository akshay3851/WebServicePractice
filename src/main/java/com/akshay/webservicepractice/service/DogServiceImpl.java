package com.akshay.webservicepractice.service;


import com.akshay.webservicepractice.entity.Dog;
import com.akshay.webservicepractice.exceptions.DogException;
import com.akshay.webservicepractice.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<String> getDogBreeds() {
        return dogRepository.retrieveDogBreed();
    }

    @Override
    public String getDogBreedById(long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.retrieveDogBreedById(id));
        String breed = optionalBreed.orElseThrow(DogException::new);
        return breed;
    }

    @Override
    public List<String> getDogNames() {
        return dogRepository.retrieveDogNames();
    }



    @Override
    public List<Dog> getAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }


}
