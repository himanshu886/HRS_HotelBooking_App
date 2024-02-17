package com.himanshu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
	
		
}
