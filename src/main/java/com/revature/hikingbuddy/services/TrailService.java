package com.revature.hikingbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewTrailRequest;
import com.revature.hikingbuddy.entities.Country;
import com.revature.hikingbuddy.entities.Trails;
import com.revature.hikingbuddy.repositories.TrailRepository;

@Service
public class TrailService {
    private TrailRepository trailrepo;

    @Autowired
    private TrailService(TrailRepository trailrepo)
    {
        this.trailrepo = trailrepo;
    }


    public Trails saveTrail(NewTrailRequest rq)
    {
        Trails trail = new Trails();
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
