package com.org.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.request.Passenger;
import com.org.response.Ticket;

@Service
public class MakeMyTripImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL = "http://localhost:8080/ticket";

	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {

		/* 
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<Ticket> resEntity =
		 * rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class); Ticket ticket =
		 * resEntity.getBody(); return ticket;
		 */

		//Creating the Object of WebClient Implementation class
		WebClient client = WebClient.create();
		//Send POST Request with passenger data
		//map response to Ticket Object
		Ticket ticket = client.post()
				.uri(BOOK_TICKET_URL)
				.bodyValue(passenger)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {

		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<Ticket> resEntity =
		 * rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNum); Ticket ticket =
		 * resEntity.getBody(); return ticket;
		 */
		
		//Creating the instance of WebClient Implementation class
		WebClient client = WebClient.create();
		// send get request and map response to Ticket Obj
		Ticket ticket = client.get()
			.uri(GET_TICKET_URL,ticketNum)
			.retrieve()
			.bodyToMono(Ticket.class)
			.block();
		
		return ticket;
	}

}
