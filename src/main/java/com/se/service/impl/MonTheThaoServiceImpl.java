package com.se.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.MonTheThaoDao;
import com.se.entity.MonTheThao;
import com.se.service.MonTheThaoService;

@Service
public class MonTheThaoServiceImpl implements MonTheThaoService {
	@Autowired
	private MonTheThaoDao monTheThaoDao;
	
	@Override
	@Transactional
	public List<MonTheThao> getAllMTT() {
		// TODO Auto-generated method stub
		return monTheThaoDao.getAllMTT();
	}

	@Override
	@Transactional
	public String getMaMTTCuoi() {
		// TODO Auto-generated method stub
		return monTheThaoDao.getMaMTTCuoi();
	}

	@Override
	@Transactional
	public void saveMTT(MonTheThao monTheThao) {
		// TODO Auto-generated method stub
		monTheThaoDao.saveMTT(monTheThao);
	}

	@Override
	@Transactional
	public MonTheThao timMonTheThaoBangTen(String tenMonTheThao) {
		// TODO Auto-generated method stub
		return monTheThaoDao.timMonTheThaoBangTen(tenMonTheThao);
	}

}
