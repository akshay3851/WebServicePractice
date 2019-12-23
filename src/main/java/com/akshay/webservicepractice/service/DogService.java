package com.akshay.webservicepractice.service;


import com.akshay.webservicepractice.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {

    List<String> getDogBreeds();

    String getDogBreedById(long id);

    List<String> getDogNames();

    List<Dog> getAllDogs();

}
