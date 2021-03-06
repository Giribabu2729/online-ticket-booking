package com.internal.training.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.internal.training.entity.OnlineTicketBooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PassengerModel {
	
	private Long id;
	
	@NotNull
	private String passengerName;

	@Size(min = 3, max = 120, message = "Age should be in between 3 - 100 years")
	private Integer age;

	private String govIdProof;

	private String gender;
	
	private OnlineTicketBooking onlineTicketBooking;

}
