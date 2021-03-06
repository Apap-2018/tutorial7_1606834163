package com.apap.tutorial7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial7.model.CarModel;
/*
 * CarDb
 */
@Repository
public interface CarDb extends JpaRepository<CarModel, Long> {
	CarModel findByType(String type);
	List<CarModel> findByDealerIdOrderByPriceDesc(long dealer_id);

}
