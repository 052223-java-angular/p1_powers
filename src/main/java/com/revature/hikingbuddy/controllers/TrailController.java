package com.revature.hikingbuddy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hikingbuddy.dtos.requests.AddToUserTrailRequest;
import com.revature.hikingbuddy.dtos.requests.GetTrailRequest;
import com.revature.hikingbuddy.dtos.requests.NewTrailRequest;
import com.revature.hikingbuddy.dtos.requests.SearchTrailRequest;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.entities.UserTrail;
import com.revature.hikingbuddy.services.TrailService;
import com.revature.hikingbuddy.services.UserTrailService;
import com.revature.hikingbuddy.utils.custom_exceptions.TrailDoesNotExistException;
import com.revature.hikingbuddy.utils.custom_exceptions.UserTrailAlreadyExistsException;

@CrossOrigin(origins="http://localhost:4200", exposedHeaders="Access-Control-Allow-Origin")
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
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    
    @GetMapping("/explore")
    public ResponseEntity<?> getTrailsNotHiked(@RequestBody GetTrailRequest rq)
    {
        List<Trail> trailsNotHiked =  usertrailservice.getAllTrailsNotHiked(rq.getUser_id());
        System.out.println("List Size: " + trailsNotHiked.size());

        return ResponseEntity.status(HttpStatus.OK).body(trailsNotHiked);
    }

   @PostMapping("/add")
   public ResponseEntity<?> addToUserTrails(@RequestBody AddToUserTrailRequest rq)
   {
        

        Optional<UserTrail> userTrailOpt = usertrailservice.findTrailByUser_id(rq.getUser_id(), rq.getTrail_name());

        if(userTrailOpt.isPresent())
        {
            throw new UserTrailAlreadyExistsException("This trail is already in the UserTrails table for user_id" + rq.getUser_id());
        }

        


        UserTrail usertrail = usertrailservice.addToUserTrails(rq);
        return ResponseEntity.status(HttpStatus.OK).build();
   }

   @GetMapping("/getAll")
   public ResponseEntity<?> getAllTrails()
   {
        List<Trail> trails = trailservice.findAllTrail();
        return ResponseEntity.status(HttpStatus.OK).body(trails);
   }

   @PostMapping("/getByName")
   public ResponseEntity<?> getTrailByName(@RequestBody SearchTrailRequest rq)
   {
        Optional<Trail> trailOpt = trailservice.findTrailByName(rq.getTrail_name());
        if(trailOpt.isEmpty())
        {
            throw new TrailDoesNotExistException("Trail Not Found. Exception thrown at TrailController.getTrailByname()");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trailOpt.get());
   }
    
    
}
