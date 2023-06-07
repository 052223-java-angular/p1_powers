package com.revature.hikingbuddy.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

@Id
@JsonManagedReference
private String id;
@Column
private String name;

public Role(String name)
{
    this.id = UUID.randomUUID().toString();
    this.name = name;
}

    
}
