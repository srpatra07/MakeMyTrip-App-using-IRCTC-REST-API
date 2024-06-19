package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.request.Passenger;
import com.org.response.Ticket;
import com.org.service.MakeMyTripImpl;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripImpl service;

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger, Model model) {
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg","Your Ticket Booked with Ticket Number : "+ticket.getTicketNum());
		return "index";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model)
	{
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum, Model model)
	{
		Ticket ticket = service.getTicket(ticketNum);
		model.addAttribute("ticket",ticket);
		return "ticket-form";
	}

}
