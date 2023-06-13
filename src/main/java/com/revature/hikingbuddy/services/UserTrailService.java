package com.revature.hikingbuddy.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.AddToUserTrailRequest;
import com.revature.hikingbuddy.entities.Trail;
import com.revature.hikingbuddy.entities.User;
import com.revature.hikingbuddy.entities.UserTrail;
import com.revature.hikingbuddy.repositories.UserTrailRepository;


@Service
public class UserTrailService {
    private UserTrailRepository usertrailrepo;

    @Autowired
    private UserTrailService(UserTrailRepository usertrailrepo)
    {
        this.usertrailrepo = usertrailrepo;
    }

    public UserTrail addToUserTrails(AddToUserTrailRequest rq)
    {
        
            UserTrail usertrail = new UserTrail();
            usertrail.setId(UUID.randomUUID().toString());
            User user = new User();
            user.setId(rq.getUser_id());
            Trail trail = new Trail();
            trail.setName(rq.getTrail_name());
            usertrail.setTrailName(trail);
            usertrail.setUser_id(user);
            usertrailrepo.save(usertrail);
            return usertrail;
        
    }

    public Optional<UserTrail> findTrailByTrail_name(Trail trailName)
    {
        return usertrailrepo.findUserTrailByTrailName(trailName);
    }
    
}
