package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouCustomerComment;
import com.pbc.goyou.entity.User;


@Repository("goyouCustomerCommentRepository")
public interface GoyouCustomerCommentRespository  extends JpaRepository<GoyouCustomerComment, Serializable> {
		public abstract GoyouCustomerComment findById(int id);
		public abstract List<GoyouCustomerComment> findAll();
		public Page<GoyouCustomerComment> findAllByOrderByIdDesc( Pageable pageable);

}