package com.internal.training.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingForm {
	
	private Long trainNumber;

	@NotNull
	@FutureOrPresent(message = "Travel date should be present or future")
	private LocalDateTime travelDate;

	private Long userId;
	
	@NotNull
	private Integer noOfPassenger;
	
	private String source;
	
	private String destination;
	
	private List<PassengerModel> passengers;
	
	
}
