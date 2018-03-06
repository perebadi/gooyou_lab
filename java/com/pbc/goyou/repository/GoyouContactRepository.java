package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.entity.User;


@Repository("goyouContactRepository")
public interface GoyouContactRepository  extends JpaRepository<GoyouContact, Serializable> {
		public abstract GoyouContact findById(int id);
		public abstract List<GoyouContact> findAll();
		public abstract List<GoyouContact> findByCustomer(GoyouCustomer customer);

		public Page<GoyouContact> findAllByOrderByIdDesc( Pageable pageable);
		
		

}