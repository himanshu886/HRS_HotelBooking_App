package com.himanshu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
