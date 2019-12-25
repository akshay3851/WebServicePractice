package com.akshay.webservicepractice.graphql.resolver;

import com.akshay.webservicepractice.entity.Dog;
import com.akshay.webservicepractice.graphql.exeptions.DogNotFoundException;
import com.akshay.webservicepractice.graphql.repository.DogGraphQlRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogGraphQlRepository dogRepository;

    public Query(DogGraphQlRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(long id) {
        Optional<Dog> optionalDog =
                dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found" , id);
        }
    }

}
