package com.pbc.goyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.repository.GoyouContactRepository;
import com.pbc.goyou.service.GoyouContactService;

@Service("goyouContactServiceImpl")
public class GoyouContactServiceImpl implements GoyouContactService {

	@Autowired
	@Qualifier("goyouContactRepository")
	private GoyouContactRepository goyouContactRepository;
	
	
	@Override
	public GoyouContact addGoyouContact(GoyouContact goyouContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoyouContact updateGoyouContact(GoyouContact goyouContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoyouContact findGoyouContactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoyouContact> listPageableGoyouContact(int pageno, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoyouContact> listPageableGoyouContact(int pageno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRecords() {
		// TODO Auto-generated method stub
		return (int) goyouContactRepository.count();
	}

}
