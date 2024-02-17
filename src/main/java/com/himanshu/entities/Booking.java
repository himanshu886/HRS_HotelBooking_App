package com.himanshu.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {
	
		//bookingId, checkindate, checkoutdate, RoomType, TotalPrice,UserId, HotelId
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer bookingId;
		
		private String roomType;
		
		private LocalDate checkInDate;
		
		private LocalDate checkOutDate;
		
		private Integer totalPrice;
		
		private Integer numOfGuests;
		
		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;
		
		@ManyToOne
		@JoinColumn(name ="hotel_id")
		private Hotel hotel;
}
