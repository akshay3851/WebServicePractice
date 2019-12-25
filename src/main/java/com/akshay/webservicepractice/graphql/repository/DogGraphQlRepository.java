package com.akshay.webservicepractice.graphql.repository;

import com.akshay.webservicepractice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogGraphQlRepository extends CrudRepository<Dog, Long> {

}
