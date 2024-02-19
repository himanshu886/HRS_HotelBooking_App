package com.himanshu.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;
	
    private String hotelName;

    private String location;
    
    @Column(length = 100)
    private String description;
    
   @OneToMany(mappedBy ="hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Booking> booking= new ArrayList<>();
    
    
}
