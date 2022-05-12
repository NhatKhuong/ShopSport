package com.se.dao;

import com.se.entity.PhanQuyen;
import com.se.entity.SanPham;

public interface PhanQuyenDao {
	public void save(PhanQuyen sanPham);
	public void delete(String maNguoiDung);
	public void update(String maNguoiDung);
}
