package com.darshan.module1.controller;

import com.darshan.lib.services.EvenOddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddController {
    @Autowired
    EvenOddService evenOddService;

    @GetMapping("/validate")
    public String isEvenOdd(@RequestParam("number") Integer number){
        return evenOddService.evenOrOdd(number);
    }
}
