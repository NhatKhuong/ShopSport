package com.se.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.NhanHieuDao;
import com.se.entity.NhanHieu;
import com.se.service.NhanHieuService;

@Service
public class NhanHieuServiceImpl implements NhanHieuService {

	@Autowired
	private NhanHieuDao nhanHieuDao;

	@Override
	@Transactional
	public List<NhanHieu> getAllNhanHieu() {
		// TODO Auto-generated method stub
		return nhanHieuDao.getAllNhanHieu();
	}

	@Override
	@Transactional
	public String getMaCuoiNhanHieu() {
		// TODO Auto-generated method stub
		return nhanHieuDao.getMaCuoiNhanHieu();
	}

	@Override
	@Transactional
	public void saveNhanHieu(NhanHieu nhanHieu) {
		// TODO Auto-generated method stub
		nhanHieuDao.saveNhanHieu(nhanHieu);

	}

	@Override
	@Transactional
	public NhanHieu timNhanHieuBangTen(String tenNhanHieu) {
		// TODO Auto-generated method stub
		return nhanHieuDao.timNhanHieuBangTen(tenNhanHieu);
	}

	@Override
	@Transactional
	public List<NhanHieu> getDanhSachThuongHieu() {
		return nhanHieuDao.getDanhSachThuongHieu();
	}
}
