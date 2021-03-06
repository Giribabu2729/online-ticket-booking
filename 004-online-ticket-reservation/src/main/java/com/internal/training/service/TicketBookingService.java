package com.internal.training.service;

import com.internal.training.model.RecentTicketBooking;

public interface TicketBookingService {

	RecentTicketBooking getRecentTicketHistory(Long userId) throws Exception;

}
