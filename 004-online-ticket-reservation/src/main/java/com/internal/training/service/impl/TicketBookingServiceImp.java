package com.internal.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.internal.training.entity.OnlineTicketBooking;
import com.internal.training.entity.Passenger;
import com.internal.training.model.PassengerModel;
import com.internal.training.model.RecentTicketBooking;
import com.internal.training.repository.OnlineTicketBookingRepository;
import com.internal.training.repository.PassengerRepository;
import com.internal.training.service.TicketBookingService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class TicketBookingServiceImp implements TicketBookingService {

	@Autowired
	OnlineTicketBookingRepository ticketRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public RecentTicketBooking getRecentTicketHistory(Long userId) throws Exception {

		RecentTicketBooking recentTicketBooking = new RecentTicketBooking();

		OnlineTicketBooking onlineTicketBooking = new OnlineTicketBooking();
		List<OnlineTicketBooking> onlineTicketBookingList = ticketRepository.findByUserIdOrderByBookingDateDesc(userId);
		if (!CollectionUtils.isEmpty(onlineTicketBookingList)) {
			onlineTicketBooking = onlineTicketBookingList.get(0);
			List<Passenger> passengerEOList = passengerRepository.findByTicketId(onlineTicketBooking.getTicketId());

			recentTicketBooking.setTicketId(onlineTicketBooking.getTicketId());

			recentTicketBooking.setBookingDateTime(onlineTicketBooking.getBookingDate());
			recentTicketBooking.setTravelDateTime(onlineTicketBooking.getTravelDate());

			recentTicketBooking.setTrainNumber(onlineTicketBooking.getTrainNumber());

			recentTicketBooking.setNoOfPassengers(onlineTicketBooking.getNoOfPassenger());

			recentTicketBooking.setTotalTicketAmout(onlineTicketBooking.getAmount());

			recentTicketBooking.setUserId(onlineTicketBooking.getUserId());

			recentTicketBooking.setSource(onlineTicketBooking.getTrainDetails().getSource());
			recentTicketBooking.setDestination(onlineTicketBooking.getTrainDetails().getDestination());

			List<PassengerModel> passengerList = new ArrayList<PassengerModel>();

			for (Passenger eachPassenger : passengerEOList) {
				PassengerModel model = new PassengerModel();
				model.setAge(eachPassenger.getAge());
				model.setPassengerName(eachPassenger.getPassengerName());
				model.setGender(eachPassenger.getGender());
				model.setGovIdProof(eachPassenger.getGovIdProof());
				passengerList.add(model);
			}

			recentTicketBooking.setPassengerList(passengerList);
			return recentTicketBooking;
		}else {
			throw new Exception("Invalid user");
		}

		
		
	}

}
