package com.revature.hikingbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.GetTrailRequest;
import com.revature.hikingbuddy.dtos.requests.NewTrailRequest;
import com.revature.hikingbuddy.entities.Trails;
import com.revature.hikingbuddy.services.TrailService;

@RestController
@RequestMapping("/trails")
public class TrailController {
    private TrailService trailservice;

    @Autowired 
    private TrailController(TrailService trailservice)
    {
        this.trailservice = trailservice;
    }
   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NewTrailRequest rq)
    {
        Trails trail = trailservice.saveTrail(rq);
        return ResponseEntity.status(HttpStatus.CREATED).body(trail);
    }

    
   /*  @GetMapping("/explore")
    public ResponseEntity<?> getTrailsNotHiked(@RequestBody GetTrailRequest rq)
    {

    }*/
    
    
}
