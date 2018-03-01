package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouContact;

public interface GoyouContactService {
		public abstract GoyouContact addGoyouContact(GoyouContact goyouContact);
		public abstract GoyouContact updateGoyouContact(GoyouContact goyouContact);
		public abstract GoyouContact findGoyouContactById(int id);
		
		
		//NEW
		public abstract List<GoyouContact> listPageableGoyouContact(int pageno, String search);
		public abstract List<GoyouContact> listPageableGoyouContact(int pageno);
		public abstract int countRecords();

	}