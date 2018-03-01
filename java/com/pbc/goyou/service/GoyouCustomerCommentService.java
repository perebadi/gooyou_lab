package com.pbc.goyou.service;

import java.util.List;

import com.pbc.goyou.entity.GoyouCustomerComment;

public interface GoyouCustomerCommentService {
		public abstract GoyouCustomerComment addGoyouCustomerComment(GoyouCustomerComment goyouCustomerComment);
		public abstract GoyouCustomerComment updateGoyouCustomerComment(GoyouCustomerComment goyouCustomerComment);
		public abstract GoyouCustomerComment findGoyouCustomerCommentById(int id);
		
		
		//NEW
		public abstract List<GoyouCustomerComment> listPageableGoyouCustomerComment(int pageno, String search);
		public abstract List<GoyouCustomerComment> listPageableGoyouCustomerComment(int pageno);
		public abstract int countRecords();

	}