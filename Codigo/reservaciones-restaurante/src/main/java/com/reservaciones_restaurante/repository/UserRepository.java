package com.reservaciones_restaurante.repository;


import com.reservaciones_restaurante.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}

