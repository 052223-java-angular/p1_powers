package com.revature.hikingbuddy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.AddToUserTrailRequest;
import com.revature.hikingbuddy.dtos.requests.NewTrailRequest;
import com.revature.hikingbuddy.entities.Country;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.entities.UserTrail;
import com.revature.hikingbuddy.repositories.TrailRepository;
import com.revature.hikingbuddy.repositories.UserTrailRepository;
import com.revature.hikingbuddy.utils.custom_exceptions.UserTrailAlreadyExistsException;

@Service
public class TrailService {
    private TrailRepository trailrepo;
    private UserTrailRepository usertrailrepo;

    @Autowired
    private TrailService(TrailRepository trailrepo, UserTrailRepository usertrailrepo)
    {
        this.trailrepo = trailrepo;
        this.usertrailrepo = usertrailrepo;
    }


    public Trail saveTrail(NewTrailRequest rq)
    {
        Trail trail = new Trail();
        trail.setName(rq.getName());
        trail.setAvgRating(rq.getAverageRating());
        trail.setTrailLength(rq.getTrailLength());
        Country country = new Country();
        country.setName(rq.getCountry_name());
        trail.setCountry_name(country);
        trailrepo.save(trail);
        return trail;
    }

    



   
    
}
