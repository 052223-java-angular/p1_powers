package com.revature.hikingbuddy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRoleRequest;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.repositories.RoleRepository;
import com.revature.hikingbuddy.utils.custom_exceptions.RoleAlreadyExistsException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class RoleService {
    private RoleRepository rolerepo;
    private static RoleService instance;

    @Autowired
    private RoleService(RoleRepository rolerepo)
    {
        this.rolerepo = rolerepo;
    }

    public void saveRole(NewRoleRequest rq)
    {
        Optional<Role> roleOpt = rolerepo.findByName(rq.getRole_name());

        if(roleOpt.isPresent())
        {
            throw new RoleAlreadyExistsException("Role Already Exists. Exception thrown at RoleService.saveRole()");
        }

        Role role = new Role(rq.getRole_name());
        rolerepo.save(role);
        
    }

    public RoleService getInstance()
    {
        if(instance == null)
        {
            instance = new RoleService(rolerepo);
        }

        return instance;
    }
    

    public Optional<Role> findById(String id)
    {
        return rolerepo.findById(id);
    }
    

    public void saveRole(Role role)
    {
        rolerepo.save(role);
    }

    public Optional<Role> getRoleByName(String name)
    {
        return rolerepo.findByName(name);
    }

  
}
