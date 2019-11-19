package com.darshan.lib.services;

import org.springframework.stereotype.Service;

@Service
public class EvenOddService {

    public String evenOrOdd(Integer i){
        return i%2==0 ? "Even" : "Odd";
    }

    public EvenOddService() {
    }
}
