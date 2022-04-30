package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.NhanHieuDao;
import com.se.entity.NhanHieu;
import com.se.service.NhanHieuService;

@Service
public class NhanHieuServiceImpl implements NhanHieuService{
	
	@Autowired
	private NhanHieuDao nhanHieuDao;

	@Override
	@Transactional
	public List<NhanHieu> getDanhSachThuongHieu() {
		return nhanHieuDao.getDanhSachThuongHieu();
	}
	
	

}
