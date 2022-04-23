package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.NguoiDungDao;
import com.se.entity.NguoiDung;
import com.se.service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService{

	@Autowired
	private NguoiDungDao nguoiDungDao;
	
	@Override
	@Transactional
	public void save(NguoiDung nguoiDung) {
		nguoiDungDao.save(nguoiDung);
		
		
	}

	@Override
	@Transactional
	public void update(NguoiDung nguoiDung) {
		nguoiDungDao.update(nguoiDung);
		
	}

	@Override
	@Transactional
	public NguoiDung getById(String id) {
		return nguoiDungDao.getById(id);
	}

	@Override
	@Transactional
	public NguoiDung getByEmail(String email) {
		return nguoiDungDao.getByEmail(email);
	}

	@Override
	@Transactional
	public List<NguoiDung> getAll() {
		// TODO Auto-generated method stub
		return nguoiDungDao.getAll();
	}
	
}
