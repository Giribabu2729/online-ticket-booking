package com.internal.training.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="train_details")
public class TrainDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainNumber;
	
	private String trainName;
	
	private String source;
	
	private String destination;
	
	private Double ticketFare;
	
	private Long totalSeats;
	
	private Long availableSeats;
	
	
}
