package com.se.dao;

import java.util.List;

import com.se.entity.LoaiKichThuoc;

public interface LoaiKichThuocDao {
	public List<LoaiKichThuoc> listLoaiKichThuoc();
	public LoaiKichThuoc getKichThuocTheoTen(String tenLoai);
}
