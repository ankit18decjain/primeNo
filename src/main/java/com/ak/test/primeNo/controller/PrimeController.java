package com.ak.test.primeNo.controller;

import com.ak.test.primeNo.exception.CalculatePrimeNoException;
import com.ak.test.primeNo.model.PrimeNumber;
import com.ak.test.primeNo.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PrimeController {

    @Autowired
    PrimeNumberService primeNumberService;


    @GetMapping("/primes/{number}")
    public ResponseEntity<PrimeNumber> returnPrimeNumbers(@PathVariable("number") Integer number){

        System.out.println("Calculate prime no controller****");
        if(number == null){
            throw new CalculatePrimeNoException("input paramere is missing please provide");
        }

        PrimeNumber response = new PrimeNumber();
        response= primeNumberService.calculatePrimeNumber(number);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
