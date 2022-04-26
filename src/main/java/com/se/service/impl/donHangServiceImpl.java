package com.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.DonHangDao;
import com.se.entity.DonHang;
import com.se.service.DonHangService;

@Service
public class donHangServiceImpl implements DonHangService {

	@Autowired 
	 private DonHangDao donHangDao;
	
	@Override
	@Transactional
	public boolean themHoaDon(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDao.themHoaDon(donHang);
	}
	
}
