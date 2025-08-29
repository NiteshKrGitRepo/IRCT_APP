package com.ait.restcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.Passenger;
import com.ait.binding.Ticket;

@RestController
public class ERailRestController {
	Map<Integer, Ticket> ticket = new HashMap<>();

	@PostMapping(value = "/ticket", consumes = { "application/xml", "application/json" })

	public Ticket addTicket(@RequestBody Passenger passenger) {

		Random rand = new Random();
		int ticketId = rand.nextInt(100, 10000);

		Ticket t = new Ticket();
		t.setTicketId(ticketId);

		t.setFname(passenger.getFname());
		t.setLname(passenger.getLname());
		t.setDoj(passenger.getDoj());
		t.setFrom(passenger.getFrom());
		t.setTo(passenger.getTo());
		t.setMob(passenger.getMob());
		t.setTicketPrice("1500");
		t.setTrainNo(12295L);
		t.setStatus("CONFIRMED");

		ticket.put(ticketId, t);
		return t;

	}

	@GetMapping(value = "/getTicket/{ticketId}", produces = { "application/json" })
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketId) {

		if (ticket.containsKey(ticketId)) {
			return ResponseEntity.ok(ticket.get(ticketId));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 

	}
}
