package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouSource;
import com.pbc.goyou.entity.User;


@Repository("goyouSourceRepository")
public interface GoyouSourceRepository  extends JpaRepository<GoyouSource, Serializable> {
		public abstract GoyouSource findById(int id);
		public abstract List<GoyouSource> findAll();
		public Page<GoyouSource> findAllByOrderByIdDesc( Pageable pageable);

}