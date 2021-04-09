package com.example.lektion1.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Christoffer Grännby
 * Date: 2021-04-08
 * Time: 11:19
 * Project: Lektion1
 * Copyright: MIT
 */

@RestController
public class Exercise1 {

    // Övning 1A
    @RequestMapping("/")
    public String index(){
        return "Hello world";
    }

    // Övning 1B
    public int randomNumber(int i){
        int min = 1;
        int max = 10;
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
    public String randomAnimal(){
        List<String> animal = Arrays.asList("tupp","sengångare","get","panda");
        Random random = new Random();
        return animal.get(random.nextInt(animal.size()));
    }
    @RequestMapping("/lucky")
    public String lucky(@RequestParam String luckyYou){
        if (luckyYou.equals("animal")){
            return randomAnimal();
        }
        else {
            return String.valueOf(randomNumber(10)+1);
        }
    }

    // Övning 1C
    @RequestMapping("/luckyoptionals")
    public String luckyOpt(@RequestParam (defaultValue = "") String firstname,
                           @RequestParam (defaultValue = "") String lastname) {
        String name;
        if (firstname.equals("") || lastname.equals("")){
            name = "Du måste ange för och efternamn";
        }
        else {
            name = firstname + " " + lastname + ", ditt lyckodjur är " + randomAnimal();
        }
        return name;
    }

    // Övning 1D
    @RequestMapping("/luckydefaults")
    public String luckyDef(@RequestParam (defaultValue = "galosch") String firstname,
                           @RequestParam (defaultValue = "galosch") String lastname) {
        String name;
        if (firstname.equals("galosch") || lastname.equals("galosch")){
            name = "Sluta fuska din gamle galosch";
        }
        else {
            name = firstname + " " + lastname + ", ditt lyckodjur är " + randomAnimal();
        }
        return name;
    }

    // Övning 1E
    @RequestMapping("/inlist")
    public String getLuckyNumber(@RequestParam List<String> unluckyNumber) {
        boolean lucky = true;
        int number = 0;
        while (lucky) {
            number = randomNumber(unluckyNumber.size()+1000);
            if (!(unluckyNumber.contains(String.valueOf(number)))){
                lucky = false;
            }
        }
        return String.valueOf(number);
    }

    // Övning 1F
    @RequestMapping("/outparam")
    public String getLuckyNumber2 (@RequestParam List<String> unluckyNumber) {
        StringBuilder response;
        response = new StringBuilder("<ul>");
        for (int i = 0; i < unluckyNumber.size()+1000; i++) {
            String numbers = String.valueOf(randomNumber(1000 - unluckyNumber.size()));
            if (!(unluckyNumber.contains("numbers"))){
                response.append("<li>").append(numbers).append("</li>");
            }
        }
        response.append("</ul>");
        return response.toString();
    }

    // Övning 1G
    @RequestMapping("/pathparam/{in}")
    public String getLuckyNumber3 (@PathVariable String input) {
        if (input.equals("animal")){
            return randomAnimal();
        }
        else {
            return String.valueOf(randomNumber(10)+1);
        }
    }
}
