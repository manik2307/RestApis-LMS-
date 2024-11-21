package com.API.examregister.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.examregister.Services.EggService;

@RestController
@RequestMapping("/api/eggs")
public class EggController {

    @Autowired
    private EggService eggService;

    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        String fact = eggService.getNumberFact(number);
        return ResponseEntity.ok(fact);
    }
}
