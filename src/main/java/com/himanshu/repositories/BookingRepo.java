package com.himanshu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.entities.Booking;
import com.himanshu.entities.Hotel;
import com.himanshu.entities.User;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
	
	List<Booking> findByUser(User user);
	
	List<Booking> findByHotel(Hotel hotel);
}
