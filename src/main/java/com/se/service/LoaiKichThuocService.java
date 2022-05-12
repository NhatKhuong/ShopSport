package com.se.service;

import java.util.List;

import com.se.entity.LoaiKichThuoc;

public interface LoaiKichThuocService {
	public List<LoaiKichThuoc> listLoaiKichThuoc();
	public LoaiKichThuoc getKichThuocTheoTen(String tenLoai);
}
