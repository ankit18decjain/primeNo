package com.ak.test.primeNo.service;

import com.ak.test.primeNo.model.PrimeNumber;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class PrimeNumberServiceImpl  implements  PrimeNumberService{

    @Override
    public PrimeNumber calculatePrimeNumber(int number) {

        PrimeNumber primeNumber = new PrimeNumber();
        List<Integer> list = Stream.iterate(0, n->n+1)
                .limit(number)
                .filter(PrimeNumberServiceImpl::isPrime)
                .peek(x->System.out.println(x))
                .collect(Collectors.toList());


        primeNumber.setNumber(number);
        primeNumber.setPrimeNumbers(list);


        return primeNumber;
    }

    public static boolean isPrime(int no){
        if(no<=1) return false;

        return !IntStream.rangeClosed(2,no/2).anyMatch(i->no%i==0) ;
    }
}
