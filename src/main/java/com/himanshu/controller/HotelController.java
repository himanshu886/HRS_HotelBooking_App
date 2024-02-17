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

import com.himanshu.entities.Hotel;
import com.himanshu.payloads.ApiResponse;
import com.himanshu.payloads.HotelDto;
import com.himanshu.services.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<HotelDto> createHotel(@Valid @RequestBody HotelDto hotelDto){
		
		HotelDto createHotel = hotelService.createHotel(hotelDto);
		return new ResponseEntity<HotelDto>(createHotel, HttpStatus.CREATED);
	}
	
	@PutMapping("/{hotelId}")
	public ResponseEntity<HotelDto> updateHotel(@Valid @RequestBody HotelDto hotelDto, @PathVariable("hotelId") Integer hotelId){
		  HotelDto updateHotel = hotelService.updateHotel(hotelDto, hotelId);
		  return ResponseEntity.ok(updateHotel);
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<ApiResponse> deleteHotel(@PathVariable("hotelId") Integer hotelId){
			hotelService.deleteHotel(hotelId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Hotel deleted Succesfully", true), HttpStatus.OK);
			
	}
	
	@GetMapping("/")
	public ResponseEntity<List<HotelDto>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<HotelDto> getHotelById(@PathVariable("hotelId") Integer hotelId){
		HotelDto hotelById = hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotelById);
	}
	
	
}
