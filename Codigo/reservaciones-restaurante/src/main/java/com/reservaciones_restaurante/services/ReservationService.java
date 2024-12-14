package com.reservaciones_restaurante.services;

import org.springframework.stereotype.Service;

import com.reservaciones_restaurante.repository.ReservationRepository;
import com.reservaciones_restaurante.model.Reservations;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    // Constructor injection
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservations> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservations> getReservationById(int id) {
        return reservationRepository.findById(id);
    }

    public Reservations createReservation(Reservations reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservations updateReservation(int id, Reservations newReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setUserId(newReservation.getUserId());
                    reservation.setTableId(newReservation.getTableId());
                    reservation.setReservationTime(newReservation.getReservationTime());
                    reservation.setStatus(newReservation.getStatus());
                    return reservationRepository.save(reservation);
                })
                .orElseGet(() -> {
                    newReservation.setId(id);
                    return reservationRepository.save(newReservation);
                });
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
