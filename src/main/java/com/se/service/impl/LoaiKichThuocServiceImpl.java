package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.LoaiKichThuocDao;
import com.se.entity.LoaiKichThuoc;
import com.se.service.LoaiKichThuocService;

@Service
public class LoaiKichThuocServiceImpl implements LoaiKichThuocService{

	@Autowired 
	 private LoaiKichThuocDao kichThuocDao;
	
	@Override
	@Transactional
	public List<LoaiKichThuoc> listLoaiKichThuoc() {
		// TODO Auto-generated method stub
		return kichThuocDao.listLoaiKichThuoc();
	}

	@Override
	@Transactional
	public LoaiKichThuoc getKichThuocTheoTen(String tenLoai) {
		// TODO Auto-generated method stub
		return kichThuocDao.getKichThuocTheoTen(tenLoai);
	}

	
}
