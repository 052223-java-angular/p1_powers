package com.revature.hikingbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.AddToUserTrailRequest;
import com.revature.hikingbuddy.dtos.requests.GetTrailRequest;
import com.revature.hikingbuddy.dtos.requests.NewTrailRequest;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.UserTrail;
import com.revature.hikingbuddy.services.TrailService;
import com.revature.hikingbuddy.services.UserTrailService;

@RestController
@RequestMapping("/trails")
public class TrailController {
    private TrailService trailservice;
    private UserTrailService usertrailservice;

    @Autowired 
    private TrailController(TrailService trailservice, UserTrailService usertrailservice)
    {
        this.trailservice = trailservice;
        this.usertrailservice = usertrailservice;
    }
   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NewTrailRequest rq)
    {
        Trail trail = trailservice.saveTrail(rq);
        return ResponseEntity.status(HttpStatus.CREATED).body(trail);
    }

    
   /*  @GetMapping("/explore")
    public ResponseEntity<?> getTrailsNotHiked(@RequestBody GetTrailRequest rq)
    {

    }*/

   @PostMapping("/add")
   public ResponseEntity<?> addToUserTrails(@RequestBody AddToUserTrailRequest rq)
   {
        UserTrail usertrail = usertrailservice.addToUserTrails(rq);
        return ResponseEntity.status(HttpStatus.OK).body(usertrail);
   }
    
    
}
