package com.se.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.HinhAnhDao;
import com.se.entity.HinhAnhSanPham;
import com.se.service.HinhAnhService;

@Service
public class HinhAnhServiceImpl implements HinhAnhService{

	@Autowired
	private HinhAnhDao hinhAnhDao;
	
	@Override
	@Transactional
	public boolean themHinhAnhSanPham(HinhAnhSanPham hinhAnhSanPham) {
		// TODO Auto-generated method stub
		return hinhAnhDao.themHinhAnhSanPham(hinhAnhSanPham);
	}

	@Override
	@Transactional
	public boolean xoaHinhAnhSanPham(String maHinhAnh) {
		// TODO Auto-generated method stub
		return hinhAnhDao.xoaHinhAnhSanPham(maHinhAnh);
	}

	@Override
	@Transactional
	public String getId() {
		// TODO Auto-generated method stub
		return hinhAnhDao.getId();
	}

}
