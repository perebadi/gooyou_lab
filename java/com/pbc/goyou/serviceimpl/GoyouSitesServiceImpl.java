package com.pbc.goyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.entity.GoyouSites;
import com.pbc.goyou.entity.GoyouSource;
import com.pbc.goyou.repository.GoyouContactRepository;
import com.pbc.goyou.repository.GoyouSitesRepository;
import com.pbc.goyou.service.GoyouContactService;
import com.pbc.goyou.service.GoyouSitesService;

@Service("goyouSitesServiceImpl")
public class GoyouSitesServiceImpl implements GoyouSitesService {

	@Autowired
	@Qualifier("goyouSitesRepository")
	private GoyouSitesRepository goyouSitesRepository;

	@Override
	public List<GoyouSites> listSitesBySource(GoyouSource source) {
		// TODO Auto-generated method stub
		return goyouSitesRepository.findBySource(source);
	}

	@Override
	public List<GoyouSites> listSites() {
		// TODO Auto-generated method stub
		return goyouSitesRepository.findAll();
	}

	@Override
	public int countRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GoyouSites addGoyouSites(GoyouSites goyouSites) {
		// TODO Auto-generated method stub
		return goyouSitesRepository.save(goyouSites);
	}

	@Override
	public GoyouSites updateGoyouSites(GoyouSites goyouSites) {
		// TODO Auto-generated method stub
		return goyouSitesRepository.save(goyouSites);
	}
	
	

}
