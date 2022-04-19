package com.se.service;

import java.util.List;

import com.se.entity.KichThuoc;

public interface KichThuocService {
	
	public List<String> getDsKichThuocTheoMaSanPham(String maSp);
	public KichThuoc getKichThuocTheoTenKichThuoc(String tenKichThuoc);
	
	

}
