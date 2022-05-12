package com.se.service;

import com.se.entity.PhanQuyen;

public interface PhanQuyenService {
	public void save(PhanQuyen sanPham);

	public void delete(String maNguoiDung);

	public void update(String maNguoiDung);
}
