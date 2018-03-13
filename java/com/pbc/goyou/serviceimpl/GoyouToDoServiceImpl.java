package com.pbc.goyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pbc.goyou.entity.GoyouToDo;
import com.pbc.goyou.repository.GoyouToDoRepository;
import com.pbc.goyou.service.GoyouToDoService;

@Service("goyouToDoServiceImpl")
public class GoyouToDoServiceImpl implements GoyouToDoService {
	
	@Autowired
	@Qualifier("goyouToDoRepository")
	private GoyouToDoRepository goyouToDoRepository;

	@Override
	public GoyouToDo addGoyouToDo(GoyouToDo goyouToDo) {
		// TODO Auto-generated method stub
		return goyouToDoRepository.save(goyouToDo);
	}

	@Override
	public GoyouToDo updateGoyouToDo(GoyouToDo goyouToDo) {
		// TODO Auto-generated method stub
		return goyouToDoRepository.save(goyouToDo);
	}

	@Override
	public GoyouToDo findGoyouToDoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoyouToDo> listPageableGoyouToDo(int pageno, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoyouToDo> listPageableGoyouToDo(int pageno) {
		return null;

	}

	@Override
	public int countRecords() {
		// TODO Auto-generated method stub
		return (int) goyouToDoRepository.count();
	}

}
