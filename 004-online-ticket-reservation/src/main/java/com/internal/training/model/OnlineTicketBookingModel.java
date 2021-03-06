package com.internal.training.model;

import java.time.LocalDateTime;

import com.internal.training.entity.OnlineTicketBooking;
import com.internal.training.entity.TrainDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlineTicketBookingModel {
	
	private LocalDateTime bookingDate;

	private LocalDateTime travelDate;

	private Long trainNumber;

	private Integer noOfPassenger;

	private Long amount;

	private String status;

	private Long userId;
	
	private TrainDetails trainDetails;

}
