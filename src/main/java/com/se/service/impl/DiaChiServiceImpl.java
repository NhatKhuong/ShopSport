package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.DiaChiDao;
import com.se.service.DiaChiService;

@Service
public class DiaChiServiceImpl implements DiaChiService{
	
	@Autowired
	private DiaChiDao diaChiDao;

	@Override
	@Transactional
	public List<String> getDanhSachTinhThanhPho() {
		// TODO Auto-generated method stub
		return diaChiDao.getDanhSachTinhThanhPho();
	}

}
