package com.akshay.webservicepractice.repository;


import com.akshay.webservicepractice.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

    public static final String RETRIEVE_DOG_BREED = "SELECT breed FROM dog";
    public static final String RETRIEVE_DOG_BREED_BY_ID = "SELECT breed FROM dog WHERE id=?1";
    public static final String RETRIEVE_DOG_NAMES = "SELECT name FROM dog";

    @Query(value = RETRIEVE_DOG_BREED, nativeQuery = true)
    public List<String> retrieveDogBreed();

    @Query(value = RETRIEVE_DOG_BREED_BY_ID, nativeQuery = true)
    public String retrieveDogBreedById(long id);

    @Query(value = RETRIEVE_DOG_NAMES, nativeQuery = true)
    public List<String> retrieveDogNames();




    /*
    * Instructor solutions
    * @Query("select d.id, d.breed from Dog d where d.id=:id")
    *String findBreedById(Long id);
    *
    *@Query("select d.id, d.breed from Dog d")
    *List<String> findAllBreed();
    *
    *@Query("select d.id, d.name from Dog d")
    *List<String> findAllName();
    *
    */


}
