package com.himanshu.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.entities.Hotel;
import com.himanshu.exceptions.ResourceNotFoundException;
import com.himanshu.payloads.HotelDto;
import com.himanshu.repositories.HotelRepo;
import com.himanshu.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HotelDto createHotel(HotelDto hotelDto) {
		Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
		Hotel addedHotel = hotelRepo.save(hotel);
		return modelMapper.map(addedHotel, HotelDto.class);
	}

	@Override
	public HotelDto updateHotel(HotelDto hotelDto, Integer hotelId) {
		
			Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "Hotel Id", hotelId));
			hotel.setHotelName(hotelDto.getHotelName());
			hotel.setLocation(hotelDto.getLocation());
			hotel.setDescription(hotelDto.getDescription());
			hotel.setImageName(hotelDto.getImageName());
			
			Hotel updatedHotel = hotelRepo.save(hotel);
			HotelDto hotelToDto = hotelToDto(updatedHotel);
			return hotelToDto;
	}
	
	@Override
	public void deleteHotel(Integer hotelId) {
		 Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "HotelId", hotelId));
		 hotelRepo.delete(hotel);
		
	}
	

	@Override
	public List<HotelDto> getAllHotels() {
			List<Hotel> hotels = hotelRepo.findAll();
			
			List<HotelDto> hotelDtos = hotels.stream().map(hotel -> hotelToDto(hotel)).collect(Collectors.toList());
			return hotelDtos;
	}

	@Override
	public HotelDto getHotelById(Integer hotelId) {
			Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "HotelId", hotelId));
			
			return hotelToDto(hotel);
	}

	@Override
	public List<HotelDto> getHotelsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Hotel dtoToHotel(HotelDto hotelDto) {
		
		Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
		return hotel;
	}
	
public HotelDto hotelToDto(Hotel hotel) {
		
		HotelDto hotelDto = modelMapper.map(hotel, HotelDto.class);
		return hotelDto;
	}



}
