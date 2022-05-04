package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.TrangThaiDonHangDao;
import com.se.entity.TrangThaiDonHang;
import com.se.service.TrangThaiDonHangService;

@Service
public class TrangThaiDonHangServiceImpl implements TrangThaiDonHangService {

	@Autowired 
	TrangThaiDonHangDao trangThaiDonHangDao;
	
	@Override
	@Transactional
	public List<TrangThaiDonHang> layDanhSachTrangThaiDonHang() {
		// TODO Auto-generated method stub
		return trangThaiDonHangDao.layDanhSachTrangThaiDonHang();
	}

}
