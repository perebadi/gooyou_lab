package com.pbc.goyou.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbc.goyou.entity.GoyouToDo;
import com.pbc.goyou.entity.User;


@Repository("goyouToDoRepository")
public interface GoyouToDoRepository  extends JpaRepository<GoyouToDo, Serializable> {
		public abstract GoyouToDo findById(int id);
		public abstract List<GoyouToDo> findAll();
		public Page<GoyouToDo> findAllByOrderByIdDesc( Pageable pageable);

}