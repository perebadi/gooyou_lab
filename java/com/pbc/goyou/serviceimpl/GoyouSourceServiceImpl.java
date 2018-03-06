package com.pbc.goyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pbc.goyou.entity.GoyouSource;
import com.pbc.goyou.repository.GoyouCustomerRepository;
import com.pbc.goyou.repository.GoyouSourceRepository;
import com.pbc.goyou.service.GoyouSourceService;

@Service("goyouSourceServiceImpl")
public class GoyouSourceServiceImpl implements GoyouSourceService {
	
	@Autowired
	@Qualifier("goyouSourceRepository")
	private GoyouSourceRepository goyouSourceRepository;

	@Override
	public GoyouSource addGoyouSource(GoyouSource goyouSource) {
		// TODO Auto-generated method stub
		return goyouSourceRepository.save(goyouSource);
	}

	@Override
	public GoyouSource updateGoyouSource(GoyouSource goyouSource) {
		// TODO Auto-generated method stub
		return goyouSourceRepository.save(goyouSource);
	}

	@Override
	public GoyouSource findGoyouSourceById(int id) {
		// TODO Auto-generated method stub
		return  goyouSourceRepository.findById(id);

	}

	@Override
	public List<GoyouSource> listPageableGoyouSource(int pageno, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoyouSource> listPageableGoyouSource(int pageno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRecords() {
		// TODO Auto-generated method stub
		return (int) goyouSourceRepository.count();
	}

}
