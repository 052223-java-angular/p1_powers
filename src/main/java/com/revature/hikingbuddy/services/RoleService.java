package com.revature.hikingbuddy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.requests.NewRoleRequest;
import com.revature.hikingbuddy.entities.Role;
import com.revature.hikingbuddy.repositories.RoleRepository;

@Service
public class RoleService {
    private RoleRepository rolerepo;
    private RoleService instance;

    @Autowired
    private RoleService(RoleRepository rolerepo)
    {
        this.rolerepo = rolerepo;
    }

    public Role saveRole(NewRoleRequest rq)
    {
        Role role = new Role();
        role.setId(rq.getRole_id());
        role.setName(rq.getRole_name());
        return rolerepo.save(role);
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
