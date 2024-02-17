package com.himanshu.payloads;

import java.time.LocalDate;

import com.himanshu.entities.Hotel;
import com.himanshu.entities.User;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookingDto {
		
	private Integer bookingId;
	
	@NotBlank
	@Size(min = 4 , message = "roomType must be min of 4 characters !!")
	private String roomType;
	
	@NotNull
	@Past
	private LocalDate checkInDate;
	
	@NotNull
	@Future
	private LocalDate checkOutDate;
	
	@NotNull(message = "price cannot be null")
	private Integer totalPrice;
	
	@NotNull(message = "should not be zero")
	private Integer numOfGuests;
	
	private UserDto user;
	
	private HotelDto hotel;
		
}
