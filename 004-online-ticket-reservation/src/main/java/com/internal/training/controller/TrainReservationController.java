package com.internal.training.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internal.training.model.RecentTicketBooking;
import com.internal.training.model.TicketBookingForm;
import com.internal.training.service.TicketBookingService;

@RestController
@RequestMapping("/online")
public class TrainReservationController {
	private static final Logger logger = LoggerFactory.getLogger(TrainReservationController.class);
	
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	
	@GetMapping("/recent-ticket-history/{userId}")
	public RecentTicketBooking getRecentTicketHistory(@PathVariable Long userId) throws Exception{
		
		RecentTicketBooking recentTicketBooking = ticketBookingService.getRecentTicketHistory(userId);
		
		logger.info("Controller");
		
		return recentTicketBooking;
		
		
		
		
		
	}
	
	
	
}
