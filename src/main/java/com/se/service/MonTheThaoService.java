package com.se.service;

import java.util.List;

import com.se.entity.MonTheThao;

public interface MonTheThaoService {
	public List<MonTheThao> getAllMTT();
	public String getMaMTTCuoi();
	public void saveMTT(MonTheThao monTheThao);
	public MonTheThao timMonTheThaoBangTen(String tenMonTheThao);
}
