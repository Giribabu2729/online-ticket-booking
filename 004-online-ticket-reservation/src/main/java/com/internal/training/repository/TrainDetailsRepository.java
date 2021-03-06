package com.internal.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.training.entity.TrainDetails;

@Repository
public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Long> {

}
