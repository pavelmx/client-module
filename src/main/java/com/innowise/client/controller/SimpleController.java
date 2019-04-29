package com.innowise.client.controller;

import com.innowise.client.service.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class SimpleController {

    @Autowired
    SimpleServiceImpl simpleService;

    @GetMapping("/cars")
    public List<String> getCars(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return  simpleService.getList();
    }
}
