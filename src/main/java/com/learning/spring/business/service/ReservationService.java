package com.learning.spring.business.service;

import com.learning.spring.business.domain.RoomReservation;
import com.learning.spring.data.entity.Guest;
import com.learning.spring.data.entity.Reservation;
import com.learning.spring.data.entity.Room;
import com.learning.spring.data.repository.GuestRepository;
import com.learning.spring.data.repository.ReservationRepository;
import com.learning.spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//by using this service annotation we are just aspecting, we can also use @Component
@Service
public class ReservationService {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomNumber(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation =  roomReservationMap.get(reservation.getRoomId());
            roomReservation.setReservationDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());

        });
        List<RoomReservation> roomReservations = new ArrayList();

        for (Long id:roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;
    }
}