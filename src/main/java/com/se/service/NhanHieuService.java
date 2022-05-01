package com.se.service;

import java.util.List;

import com.se.entity.NhanHieu;

public interface NhanHieuService {
	public List<NhanHieu> getAllNhanHieu();
	public String getMaCuoiNhanHieu();
	public void saveNhanHieu(NhanHieu nhanHieu);
	public NhanHieu timNhanHieuBangTen(String tenNhanHieu);
}
