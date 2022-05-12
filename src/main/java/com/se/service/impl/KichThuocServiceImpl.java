package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.KichThuocDao;
import com.se.entity.KichThuoc;
import com.se.service.KichThuocService;

@Service
public class KichThuocServiceImpl implements KichThuocService{
	
	@Autowired
	private KichThuocDao kichThuocDao;

	@Override
	@Transactional
	public List<String> getDsKichThuocTheoMaSanPham(String maSp) {
		// TODO Auto-generated method stub
		return kichThuocDao.getDsKichThuocTheoMaSanPham(maSp);
	}

	@Override
	@Transactional
	public KichThuoc getKichThuocTheoTenKichThuoc(String tenKichThuoc) {
		// TODO Auto-generated method stub
		return kichThuocDao.getKichThuocTheoTenKichThuoc(tenKichThuoc);
	}

	@Override
	@Transactional
	public List<KichThuoc> getKichThuocTheoLoaiKichThuoc(String maLoaiKichThuoc) {
		// TODO Auto-generated method stub
		return kichThuocDao.getKichThuocTheoLoaiKichThuoc(maLoaiKichThuoc);
	}


}
