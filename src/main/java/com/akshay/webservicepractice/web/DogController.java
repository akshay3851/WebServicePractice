package com.akshay.webservicepractice.web;

import com.akshay.webservicepractice.entity.Dog;
import com.akshay.webservicepractice.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;


    @GetMapping("/dogs")
    @ResponseBody
    public ResponseEntity<List<Dog>> getAllDogs() {
        return new ResponseEntity<List<Dog>>(dogService.getAllDogs(), HttpStatus.OK);
    }


    @GetMapping("/dogBreeds")
    @ResponseBody
    public ResponseEntity<List<String>> getDogBreeds() {
        return new ResponseEntity<List<String>>(dogService.getDogBreeds(), HttpStatus.OK);
    }


    @GetMapping("/{id}/dogBreedById")
    @ResponseBody
    public ResponseEntity<String> getDogBreedbyId(@PathVariable("id") long id) {
        return new ResponseEntity<String>(dogService.getDogBreedById(id), HttpStatus.OK);
    }

    @GetMapping("/dogNames")
    @ResponseBody
    public ResponseEntity<List<String>> getDogNames() {
        return new ResponseEntity<List<String>>(dogService.getDogNames(), HttpStatus.OK);
    }

}
