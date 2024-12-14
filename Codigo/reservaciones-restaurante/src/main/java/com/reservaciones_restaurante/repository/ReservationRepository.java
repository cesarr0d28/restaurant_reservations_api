package com.reservaciones_restaurante.repository;

import com.reservaciones_restaurante.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservations, Integer> {
}
