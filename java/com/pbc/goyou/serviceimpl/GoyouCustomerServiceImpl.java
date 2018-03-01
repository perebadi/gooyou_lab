package com.pbc.goyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.repository.GoyouCustomerRepository;
import com.pbc.goyou.service.GoyouCustomerService;

@Service("goyouCustomerServiceImpl")
public class GoyouCustomerServiceImpl implements GoyouCustomerService {
	
	
	@Autowired
	@Qualifier("goyouCustomerRepository")
	private GoyouCustomerRepository goyouCustomerRepository;
	

	@Override
	public GoyouCustomer addGoyouCustomer(GoyouCustomer goyouCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoyouCustomer updateGoyouCustomer(GoyouCustomer goyouCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoyouCustomer findGoyouCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoyouCustomer> listPageableGoyouCustomer(int pageno, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoyouCustomer> listPageableGoyouCustomer(int pageno) {
		Page<GoyouCustomer> pagecustomers = goyouCustomerRepository.findAll(new PageRequest(pageno, 10, Sort.Direction.DESC, "id"));		
		
		return pagecustomers;	
	}

	@Override
	public int countRecords() {
		// TODO Auto-generated method stub
		return (int) goyouCustomerRepository.count();
	}

}
