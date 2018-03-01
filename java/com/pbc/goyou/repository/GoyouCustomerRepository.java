package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouCustomer;


@Repository("goyouCustomerRepository")
public interface GoyouCustomerRepository  extends JpaRepository<GoyouCustomer, Serializable> {
		public abstract GoyouCustomer findById(int id);
		public abstract List<GoyouCustomer> findAll();
		public Page<GoyouCustomer> findAllByOrderByIdDesc( Pageable pageable);

}