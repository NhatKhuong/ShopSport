package com.se.dao;

import java.util.List;

import com.se.entity.NguoiDung;

public interface NguoiDungDao {

	public void save(NguoiDung nguoiDung);

	public void update(NguoiDung nguoiDung);

	public NguoiDung getById(String id);

	public NguoiDung getByEmail(String email);

	public List<NguoiDung> getAll();

	public List<NguoiDung> getByFilter(String hoten, String diaChi);

	public void deletePerson(String theId);

	public List<NguoiDung> getByName_Status(String hoTen, int trangThai);

	boolean capNhatNguoiDung(String maNguoiDung, String hoTen, String diaChiChiTiet, int gioiTinh, int trangThai,
			String matKhau);

	public boolean capNhatMatKhauNguoiDung(String maNguoiDung, String matKhau);

	public String getMaNguoiDungCuoiCung();

}
