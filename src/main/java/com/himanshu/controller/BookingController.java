package com.himanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.payloads.ApiResponse;
import com.himanshu.payloads.BookingDto;
import com.himanshu.services.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//create
	@PostMapping("/user/{userId}/hotel/{hotelId}/bookings")
	public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto, @PathVariable Integer userId, @PathVariable Integer hotelId ){
		BookingDto createBooking = bookingService.createBooking(bookingDto,userId, hotelId);
		return new ResponseEntity<BookingDto>(createBooking, HttpStatus.CREATED);
	}
	
	@PutMapping("/bookings/{bookId}")
	public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookDto ,@PathVariable Integer bookId){
		
		BookingDto updateBooking = bookingService.updateBooking(bookDto, bookId);
		return new ResponseEntity<BookingDto>(updateBooking, HttpStatus.OK);
	}
		
	@GetMapping("/user/{userId}/bookings")
	public ResponseEntity<List<BookingDto>> getBooksByUser(@PathVariable Integer userId){
			
		List<BookingDto> bookingsByUser = bookingService.getBookingsByUser(userId);
		return new ResponseEntity<List<BookingDto>>(bookingsByUser, HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{hotelId}/bookings")
	public ResponseEntity<List<BookingDto>> getBooksByHotel(@PathVariable Integer hotelId){
			
		List<BookingDto> bookingsByHotel = bookingService.getBookingsByHotel(hotelId);
		return new ResponseEntity<List<BookingDto>>(bookingsByHotel, HttpStatus.OK);
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDto>> getAllBookings(){
		
		List<BookingDto> allBookings = bookingService.getAllBookings();
		return new ResponseEntity<List<BookingDto>>(allBookings,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{bookId}")
	public ResponseEntity<ApiResponse> deleteBookingById(@PathVariable Integer bookId){
		
			bookingService.deleteBooking(bookId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Booking deleted Succesfully",true),HttpStatus.OK);
	}
	
	@GetMapping("books/{bookId}")
	public ResponseEntity<BookingDto> getBookingById(@PathVariable Integer bookId){
			
			 BookingDto bookingById = bookingService.getBookingById(bookId);
			 return ResponseEntity.ok(bookingById);
		
	}


}
