package com.revature.hikingbuddy.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trails")
public class Trail {
    @Id
    private String name;
    @Column
    private double avgRating;
    @Column
    private double trailLength;
    @ManyToOne
    @JoinColumn(name = "country_name")
    private Country country_name;

   /*  @JsonManagedReference
    @OneToMany(mappedBy = "trail_name", fetch = FetchType.LAZY)
    private Set<UserTrail> user_trails;*/
   
    
}
