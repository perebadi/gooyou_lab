package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.entity.GoyouSites;
import com.pbc.goyou.entity.GoyouSource;

public interface GoyouSitesService {
	
	public abstract GoyouSites addGoyouSites(GoyouSites goyouSites);
	public abstract GoyouSites updateGoyouSites(GoyouSites goyouSites);
		//NEW
		public abstract List<GoyouSites> listSitesBySource(GoyouSource source);
		public abstract List<GoyouSites> listSites();
		public abstract int countRecords();

	}