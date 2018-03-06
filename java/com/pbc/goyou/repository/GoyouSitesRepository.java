package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouSites;
import com.pbc.goyou.entity.GoyouSource;

@Repository("goyouSitesRepository")
public interface GoyouSitesRepository extends JpaRepository<GoyouSites, Serializable> {
	public abstract GoyouSites findById(int id);
	public abstract List<GoyouSites> findBySource(GoyouSource source);

	public abstract List<GoyouSites> findAll();

}