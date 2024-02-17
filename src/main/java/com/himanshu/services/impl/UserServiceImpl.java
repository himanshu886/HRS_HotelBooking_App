package com.himanshu.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.entities.User;
import com.himanshu.exceptions.ResourceNotFoundException;
import com.himanshu.payloads.UserDto;
import com.himanshu.repositories.UserRepo;
import com.himanshu.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id" , userId));
		
		user.setName(userDto.getName()); // here we are setting
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = userRepo.save(user); // here we are updating
		UserDto userDto1 = userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id", userId));
		//user not found with this id with show in exception
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		//we have user lamda stream to convert list of users into list of userDto
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id",userId));
		// TODO Auto-generated method stub
		
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		
//		User user = new User();
		
		User user = modelMapper.map(userDto,User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	public UserDto userToDto(User user) {
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
//	 
		
		return userDto;
	}

}
