package com.akshay.webservicepractice.exceptions;

import com.akshay.webservicepractice.entity.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not Found")
public class DogException extends RuntimeException {
    public DogException(){}

    public DogException(String message) {
        super(message);
    }

}
