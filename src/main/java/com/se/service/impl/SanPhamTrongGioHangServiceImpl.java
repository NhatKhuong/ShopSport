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
	public void add(SanPhamTrongGioHang sanPhamTrongGioHang) {
		sanPhamTrongGioHangDao.add(sanPhamTrongGioHang);
		
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		sanPhamTrongGioHangDao.delete(id);
		
	}

	@Override
	@Transactional
	public void update(SanPhamTrongGioHang sanPhamTrongGioHang) {
		sanPhamTrongGioHangDao.update(sanPhamTrongGioHang);
		
		
	}

	@Override
	@Transactional
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung) {
		return sanPhamTrongGioHangDao.getDSSanPhamTrongGioHangTheoMaNguoiDung(maNguoiDung);
	}

	@Override
	@Transactional
	public SanPhamTrongGioHang getById(String id) {
		// TODO Auto-generated method stub
		return sanPhamTrongGioHangDao.getById(id);
	}
	
		

}
