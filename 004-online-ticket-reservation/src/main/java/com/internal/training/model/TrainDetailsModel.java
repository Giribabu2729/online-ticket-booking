package com.internal.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDetailsModel {

	private String trainName;

	private String source;

	private String destination;

	private Double ticketFare;

	private Long totalSeats;

	private Long availableSeats;

}
