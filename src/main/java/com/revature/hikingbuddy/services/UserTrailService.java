package com.revature.hikingbuddy.services;

import java.util.List;
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
    private UserService userservice;

    @Autowired
    private UserTrailService(UserTrailRepository usertrailrepo, UserService userservice)
    {
        this.usertrailrepo = usertrailrepo;
        this.userservice = userservice;
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

    public Optional<UserTrail> findTrailByUser_id(String user_id, String trail_name)
    {
        
        return usertrailrepo.findUserTrailByUser_id(user_id, trail_name);
    }

    public List<Trail> getAllTrailsNotHiked(String user_id)
    {
        return usertrailrepo.findAllTrailsNotHiked(user_id);
    }
    
}
