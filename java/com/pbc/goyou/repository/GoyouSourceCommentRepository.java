package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouSourceComment;
import com.pbc.goyou.entity.User;


@Repository("goyouSourceCommentRepository")
public interface GoyouSourceCommentRepository  extends JpaRepository<GoyouSourceComment, Serializable> {
		public abstract GoyouSourceComment findById(int id);
		public abstract List<GoyouSourceComment> findAll();
		public Page<GoyouSourceComment> findAllByOrderByIdDesc( Pageable pageable);

}