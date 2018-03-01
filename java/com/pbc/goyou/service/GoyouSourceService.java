package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouSource;

public interface GoyouSourceService {
		public abstract GoyouSource addGoyouSource(GoyouSource goyouSource);
		public abstract GoyouSource updateGoyouSource(GoyouSource goyouSource);
		public abstract GoyouSource findGoyouSourceById(int id);
		
		
		//NEW
		public abstract List<GoyouSource> listPageableGoyouSource(int pageno, String search);
		public abstract List<GoyouSource> listPageableGoyouSource(int pageno);
		public abstract int countRecords();

	}