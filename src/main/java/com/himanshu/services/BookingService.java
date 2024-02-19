package com.himanshu.services;

import java.util.List;

import com.himanshu.entities.Booking;
import com.himanshu.payloads.BookingDto;
import com.himanshu.payloads.HotelDto;

public interface BookingService {
	
	    BookingDto createBooking(BookingDto bookingDto, Integer userId, Integer hotelId);
		
		BookingDto updateBooking(BookingDto bookingDto, Integer bookId);
	    
	
		public void deleteBooking(Integer bookingId);
		
		public BookingDto getBookingById(Integer bookingId);
	
		List<BookingDto> getAllBookings();

		List<BookingDto> getBookingsByUser(Integer userId);
		
		List<BookingDto> getBookingsByHotel(Integer hotelId);
}
