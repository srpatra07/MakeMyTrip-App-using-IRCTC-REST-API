package com.org.response;

import lombok.Data;

@Data
public class Ticket {

	private Integer ticketNum;
	private Double ticketCost;
	private String status;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNum;
	
}
