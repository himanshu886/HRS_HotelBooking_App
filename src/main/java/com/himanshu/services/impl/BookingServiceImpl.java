package com.himanshu.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.entities.Booking;
import com.himanshu.entities.Hotel;
import com.himanshu.entities.User;
import com.himanshu.exceptions.ResourceNotFoundException;
import com.himanshu.payloads.BookingDto;
import com.himanshu.payloads.HotelDto;
import com.himanshu.repositories.BookingRepo;
import com.himanshu.repositories.HotelRepo;
import com.himanshu.repositories.UserRepo;
import com.himanshu.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private HotelRepo hotelRepo;
		
	@Autowired
	private BookingRepo bookingRepo;
	
	@Override
	public BookingDto createBooking(BookingDto bookingDto, Integer userId, Integer hotelId) {
		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		
		Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "Hotel id", hotelId));
		
		Booking book = modelMapper.map(bookingDto, Booking.class);
		
		book.setUser(user);
		book.setHotel(hotel);

		Booking addedBook = bookingRepo.save(book);
		
		return modelMapper.map(addedBook, BookingDto.class);
	}

//	@Override
//	public BookingDto updateBooking(BookingDto bookingDto, Integer userId) {
//		User user = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "Booking Id", bookingId));
//		
//		book.setCheckInDate(bookingDto.getCheckInDate());
//		book.setCheckOutDate(bookingDto.getCheckOutDate());
//		book.setNumOfGuests(bookingDto.getNumOfGuests());
//		book.setRoomType(bookingDto.getRoomType());
//		book.setTotalPrice(bookingDto.getTotalPrice());
//		
//		Booking updatedBook = bookingRepo.save(book);
//		
//		return modelMapper.map(updatedBook, BookingDto.class);
//	}

//	@Override
//	public void deleteBooking(Integer bookingId) {
//		
//		Booking book = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "Booking Id", bookingId));
//		bookingRepo.delete(book);
//	}

//	@Override
//	public BookingDto getBooking(Integer bookingId) {
//		
//		Booking book = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "Booking Id", bookingId));
//		return modelMapper.map(book, BookingDto.class);
//		
//	}

//	@Override
//	public List<BookingDto> getBookings() {
//		
//		List<Booking> bookList = bookingRepo.findAll();
//		
//		List<BookingDto> bookingDtos = bookList.stream().map((book)-> modelMapper.map(book, BookingDto.class)).collect(Collectors.toList());
//		
//		return bookingDtos;
//	}

	@Override
	public List<BookingDto> getBookingsByUser(Integer userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
			List<Booking> bookings = bookingRepo.findByUser(user);
			
			List<BookingDto> bookingDtos = bookings.stream().map((booking)-> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
			return bookingDtos;
	}

	@Override
	public List<BookingDto> getBookingsByHotel(Integer hotelId) {

			Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel","HotelId", hotelId));
			
			List<Booking> bookings = bookingRepo.findByHotel(hotel);
			
			List<BookingDto> bookingDtos = bookings.stream().map((booking)-> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
			return bookingDtos;
	}

	@Override
	public List<BookingDto> getAllBookings() {
			 List<Booking> bookings = bookingRepo.findAll();
			 List<BookingDto> collect = bookings.stream().map((booking)->modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
			 return collect;
	}

	@Override
	public void deleteBooking(Integer bookingId) {
			 Booking book = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "BookingId", bookingId));
			 bookingRepo.delete(book);
		
	}

	@Override
	public BookingDto getBookingById(Integer bookingId) {
		Booking book = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "BookingId", bookingId));
		
		return modelMapper.map(book, BookingDto.class);
			
	}

	@Override
	public BookingDto updateBooking(BookingDto bookingDto, Integer bookingId) {
		Booking book = bookingRepo.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "BookingId", bookingId));
		
		book.setCheckInDate(bookingDto.getCheckInDate());
		book.setCheckOutDate(bookingDto.getCheckOutDate());
		book.setNumOfGuests(bookingDto.getNumOfGuests());
		book.setRoomType(bookingDto.getRoomType());
		book.setTotalPrice(bookingDto.getTotalPrice());
		
		Booking updatedBook = bookingRepo.save(book);
		
		return modelMapper.map(updatedBook, bookingDto.getClass());	
	}

//	@Override
//	public BookingDto updateBooking(BookingDto bookingDto, Integer bookId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteBooking(Integer bookingId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public BookingDto getBookingById(Integer bookingId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}


