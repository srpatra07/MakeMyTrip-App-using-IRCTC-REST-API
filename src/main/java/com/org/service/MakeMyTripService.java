package com.org.service;

import com.org.request.Passenger;
import com.org.response.Ticket;

public interface MakeMyTripService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNum);
	
}
