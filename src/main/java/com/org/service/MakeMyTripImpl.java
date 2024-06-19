package com.org.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.request.Passenger;
import com.org.response.Ticket;

@Service
public class MakeMyTripImpl implements MakeMyTripService {
	
	private String BOOK_TICKET_URL = "http://localhost:8080/ticket";
	
	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> resEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket = resEntity.getBody();
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> resEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class,ticketNum);
		Ticket ticket = resEntity.getBody();
		
		return ticket;
	}

}
