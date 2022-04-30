package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.LoaiSanPhamDao;
import com.se.entity.LoaiSanPham;
import com.se.service.LoaiSanPhamService;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
	
	@Autowired
	private LoaiSanPhamDao loaiSanPhamDao;

	@Override
	@Transactional
	public List<LoaiSanPham> getDanhSachTenLoaiSanPham() {
		return loaiSanPhamDao.getDanhSachTenLoaiSanPham();
	}
	
	

}
