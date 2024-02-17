package com.himanshu.services;

import java.util.List;

import com.himanshu.entities.Hotel;
import com.himanshu.payloads.HotelDto;

public interface HotelService {
	
		HotelDto createHotel(HotelDto hotelDto);
		
		HotelDto updateHotel(HotelDto hotelDto, Integer hotelId);
		
		void deleteHotel(Integer hotelId);
		
		List<HotelDto> getAllHotels();	
		
		HotelDto getHotelById(Integer hotelId);
		
		List<HotelDto> getHotelsByUser(Integer userId);
		
}
