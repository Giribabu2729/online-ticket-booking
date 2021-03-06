package com.internal.training.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentTicketBooking {

	private Long ticketId;

	private Long userId;

	private Long trainNumber;

	private Long totalTicketAmout;

	private Integer noOfPassengers;

	private LocalDateTime bookingDateTime;

	private LocalDateTime travelDateTime;

	private String destination;

	private String source;

	private List<PassengerModel> passengerList;

}
