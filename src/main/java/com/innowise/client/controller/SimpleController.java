package com.innowise.client.controller;

import com.innowise.client.service.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/cars")
    public List<String> getCars(){
        return  simpleService.getList();
    }


    @GetMapping("/home")
    public String getIndex(){
        return   "Home page resources server";
    }

}
