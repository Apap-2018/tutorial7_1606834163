package com.apap.tutorial7.service;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;

	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		// TODO Auto-generated method stub
		return dealerDb.findById(id);
	}

	@Override
	public DealerModel addDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.save(dealer);
		return dealer;
	}

	@Override
	public void deleteDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.delete(dealer);

	}

	@Override
	public void updateDealer(Long id, String alamat, String noTelp) {
		// TODO Auto-generated method stub
		DealerModel updateDealer = dealerDb.getOne(id);
		updateDealer.setAlamat(alamat);
		updateDealer.setNoTelp(noTelp);
		dealerDb.save(updateDealer);
		
	}

	@Override
	public List<DealerModel> viewAllDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}

	@Override
	public void updateDealer(long id, DealerModel dealer) {
		// TODO Auto-generated method stub
		DealerModel updateDealer = dealerDb.getOne(id);
		updateDealer.setAlamat(dealer.getAlamat());
		updateDealer.setNoTelp(dealer.getNoTelp());
		dealerDb.save(updateDealer);

		
	}

}
