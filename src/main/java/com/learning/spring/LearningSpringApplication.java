package com.learning.spring;

import com.learning.spring.data.entity.Guest;
import com.learning.spring.data.entity.Reservation;
import com.learning.spring.data.entity.Room;
import com.learning.spring.data.repository.GuestRepository;
import com.learning.spring.data.repository.ReservationRepository;
import com.learning.spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringApplication.class, args);
	}


	//Not a way to do this
	//Just used for POC
/*	@RestController
	@RequestMapping("/rooms")
	public class RoomController {

		@Autowired
		private RoomRepository roomRepository;

		@GetMapping
		public Iterable<Room> getRooms() {
			return this.roomRepository.findAll();
		}
	}

	@RestController
	@RequestMapping("/guests")
	public class GuestController {

		@Autowired
		private GuestRepository guestRepository;

		@GetMapping
		public Iterable<Guest> getGuests() {
			return this.guestRepository.findAll();
		}
	}

	@RestController
	@RequestMapping("/reservations")
	public class ReservationController {

		@Autowired
		private ReservationRepository reservationRepository;

		@GetMapping
		public Iterable<Reservation> getReservations() {
			return this.reservationRepository.findAll();
		}
	}*/
}
