package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.MonTheThaoDao;
import com.se.entity.MonTheThao;
import com.se.service.MonTheThaoService;

@Service
public class MonTheThaoServiceImpl implements MonTheThaoService{
	
	@Autowired
	private MonTheThaoDao monTheThaoDao;

	@Override
	@Transactional
	public List<MonTheThao> getDanhSachTenMonTheThao() {
		return monTheThaoDao.getDanhSachTenMonTheThao();
	}

}
