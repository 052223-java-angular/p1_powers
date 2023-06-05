package com.revature.hikingbuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.hikingbuddy.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

    public User getUserById();

    public void insertUserIntoDatabase();

    public void deleteUser();

    public User changeUserIdOrPassword();

    

}
