package com.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.PhanQuyenDao;
import com.se.entity.PhanQuyen;
import com.se.service.PhanQuyenService;

@Service
public class PhanQuyenServiceImpl implements PhanQuyenService {

	@Autowired
	private PhanQuyenDao phanQuyenDao;

	@Override
	@Transactional
	public void save(PhanQuyen sanPham) {
		// TODO Auto-generated method stub
		phanQuyenDao.save(sanPham);
	}

	@Override
	@Transactional
	public void delete(String maNguoiDung) {
		// TODO Auto-generated method stub
		phanQuyenDao.delete(maNguoiDung);
	}

	@Override
	@Transactional
	public void update(String maNguoiDung) {
		// TODO Auto-generated method stub
		phanQuyenDao.update(maNguoiDung);
	}

}
