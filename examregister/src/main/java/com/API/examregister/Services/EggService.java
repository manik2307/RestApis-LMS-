package com.API.examregister.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class EggService {

    public String getNumberFact(int number) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + number;
        return restTemplate.getForObject(url, String.class);
    }
    
}
