package com.innowise.client.controller;

import com.innowise.client.service.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SimpleController {

    @Autowired
    SimpleServiceImpl simpleService;

    @GetMapping("/cars")
    public List<String> getCars(){
        return  simpleService.getList();
    }


    @GetMapping("/home")
    public String getIndex(){
        //OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        //String token = oAuth2AuthenticationDetails.getTokenValue();
        return   "Home page resources server token = " ;
    }

}
