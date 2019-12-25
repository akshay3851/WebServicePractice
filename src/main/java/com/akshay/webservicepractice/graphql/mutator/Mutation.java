package com.akshay.webservicepractice.graphql.mutator;

import com.akshay.webservicepractice.entity.Dog;
import com.akshay.webservicepractice.exceptions.DogException;
import com.akshay.webservicepractice.graphql.exeptions.DogNotFoundException;
import com.akshay.webservicepractice.graphql.repository.DogGraphQlRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogGraphQlRepository dogRepository;

    public Mutation(DogGraphQlRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new DogNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }



    public Dog updateDogName(String newName, long id) {
        Optional<Dog> mutateDogName =
                dogRepository.findById(id);

        if(mutateDogName.isPresent()) {
            Dog dog = mutateDogName.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }

    }

}
