package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
 * createdAt: 04/10/2022
 * */
@Entity
@IdClass(SanPhamTrongGioHangPK.class)
public class SanPhamTrongGioHang {
	@Id 
	@ManyToOne
	@JoinColumn(name="maChiTietSanPham")
	private ChiTietSanPham chiTietSanPham;
	@Id 
	@ManyToOne
	@JoinColumn(name="maNguoiDung")
	private NguoiDung nguoiDung;
	
	private int soLuong;
	
	public SanPhamTrongGioHang(ChiTietSanPham chiTietSanPham, NguoiDung nguoiDung, int soLuong) {
		super();
		this.chiTietSanPham = chiTietSanPham;
		this.nguoiDung = nguoiDung;
		this.soLuong = soLuong;
	}
	public SanPhamTrongGioHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietSanPham getChiTietSanPham() {
		return chiTietSanPham;
	}
	public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "SanPhamTrongGioHang [chiTietSanPham=" + chiTietSanPham + ", nguoiDung=" + nguoiDung + ", soLuong="
				+ soLuong + "]";
	}
	
	
}
