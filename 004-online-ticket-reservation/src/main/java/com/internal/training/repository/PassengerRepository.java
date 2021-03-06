package com.internal.training.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.training.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
	List<Passenger> findByTicketId(Long ticketId);
}
