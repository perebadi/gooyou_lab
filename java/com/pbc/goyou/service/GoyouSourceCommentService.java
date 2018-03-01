package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouSourceComment;

public interface GoyouSourceCommentService {
		public abstract GoyouSourceComment addGoyouSourceComment(GoyouSourceComment goyouSourceComment);
		public abstract GoyouSourceComment updateGoyouSourceComment(GoyouSourceComment goyouSourceComment);
		public abstract GoyouSourceComment findGoyouSourceCommentById(int id);
		
		
		//NEW
		public abstract List<GoyouSourceComment> listPageableGoyouSourceComment(int pageno, String search);
		public abstract List<GoyouSourceComment> listPageableGoyouSourceComment(int pageno);
		public abstract int countRecords();

	}