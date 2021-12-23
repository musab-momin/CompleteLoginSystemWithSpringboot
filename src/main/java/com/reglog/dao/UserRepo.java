package com.reglog.dao;

import com.reglog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer>
{
   Optional<User> getByEmail(String email);


}
