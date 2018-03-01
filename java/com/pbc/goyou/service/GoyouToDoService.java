package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouToDo;

public interface GoyouToDoService {
		public abstract GoyouToDo addGoyouToDo(GoyouToDo goyouToDo);
		public abstract GoyouToDo updateGoyouToDo(GoyouToDo goyouToDo);
		public abstract GoyouToDo findGoyouToDoById(int id);
		
		
		//NEW
		public abstract List<GoyouToDo> listPageableGoyouToDo(int pageno, String search);
		public abstract List<GoyouToDo> listPageableGoyouToDo(int pageno);
		public abstract int countRecords();

	}