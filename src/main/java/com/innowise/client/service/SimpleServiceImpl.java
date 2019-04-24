package com.innowise.client.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleServiceImpl {

    public List<String> getList(){
        List<String> cars = new ArrayList<>();
        cars.add("BMW");cars.add("AUDI");cars.add("McLaren");
        cars.add("FERRARI");cars.add("VOLKSWAGEN");cars.add("LADA");
        cars.add("RENAULT");cars.add("CITROEN");cars.add("PEUGEOT");
        cars.add("LAMBORGINI");cars.add("BYGATTI");cars.add("MERCEDES-BENZ");
        return cars;
    }
}
