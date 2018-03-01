package com.pbc.goyou.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pbc.goyou.entity.GoyouCustomer;

public interface GoyouCustomerService {
		public abstract GoyouCustomer addGoyouCustomer(GoyouCustomer goyouCustomer);
		public abstract GoyouCustomer updateGoyouCustomer(GoyouCustomer goyouCustomer);
		public abstract GoyouCustomer findGoyouCustomerById(int id);
		
		
		//NEW
		public abstract Page<GoyouCustomer> listPageableGoyouCustomer(int pageno, String search);
		public abstract Page<GoyouCustomer> listPageableGoyouCustomer(int pageno);
		public abstract int countRecords();

	}