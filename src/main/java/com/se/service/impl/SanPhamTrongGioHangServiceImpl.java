package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.SanPhamTrongGioHangDao;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.SanPhamTrongGioHangService;

@Service
public class SanPhamTrongGioHangServiceImpl implements SanPhamTrongGioHangService{
	
	@Autowired
	private SanPhamTrongGioHangDao sanPhamTrongGioHangDao;

	@Override
	@Transactional
	public void add(SanPhamTrongGioHangDao sanPhamTrongGioHang) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(String maChiTietSan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void update(SanPhamTrongGioHangDao sanPhamTrongGioHang) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	@Transactional
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung) {
		return sanPhamTrongGioHangDao.getDSSanPhamTrongGioHangTheoMaNguoiDung(maNguoiDung);
	}
	
		

}
