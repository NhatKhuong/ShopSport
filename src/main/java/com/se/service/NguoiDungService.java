package com.se.service;

import java.util.List;

import com.se.entity.NguoiDung;

public interface NguoiDungService {
	public void save(NguoiDung nguoiDung);
	public void update(NguoiDung nguoiDung);
	public NguoiDung  getById(String id);
	public NguoiDung getByEmail(String email);
	public List<NguoiDung> getAll();
}
