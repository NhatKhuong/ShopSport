package com.se.dao;

import java.util.List;

import com.se.entity.MonTheThao;

public interface MonTheThaoDao {
	public List<MonTheThao> getAllMTT();
	public String getMaMTTCuoi();
	public void saveMTT(MonTheThao monTheThao);
	public MonTheThao timMonTheThaoBangTen(String tenMonTheThao);
	public List<MonTheThao> getDanhSachTenMonTheThao();
}
