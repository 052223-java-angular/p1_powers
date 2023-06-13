package com.revature.hikingbuddy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user_trail")
public class UserTrail {

    @Id
    private String id;

    @JsonBackReference(value = "user_reference")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @JsonBackReference(value = "trail_reference")
    @ManyToOne
    @JoinColumn(name = "trail_name")
    private Trail trail_name;

    
}
