package com.internal.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.training.entity.OnlineTicketBooking;

@Repository
public interface OnlineTicketBookingRepository extends JpaRepository<OnlineTicketBooking, Long> {

	List<OnlineTicketBooking> findByUserIdOrderByBookingDateDesc(Long userId);
	
	
}
