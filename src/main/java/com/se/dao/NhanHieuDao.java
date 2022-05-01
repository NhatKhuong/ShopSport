package com.se.dao;

import java.util.List;

import com.se.entity.NhanHieu;

public interface NhanHieuDao {
	public List<NhanHieu> getAllNhanHieu();
	public String getMaCuoiNhanHieu();
	public void saveNhanHieu(NhanHieu nhanHieu);
	public NhanHieu timNhanHieuBangTen(String tenNhanHieu);
}
