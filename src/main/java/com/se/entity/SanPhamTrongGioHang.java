package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * createdAt: 04/10/2022
 * */
@Entity

public class SanPhamTrongGioHang {
	@Id
	private String maSanPhamTrongGioHang;
	
	@ManyToOne
	@JoinColumn(name="maChiTietSanPham")
	private ChiTietSanPham chiTietSanPham;
	
	@ManyToOne
	@JoinColumn(name="maNguoiDung")
	private NguoiDung nguoiDung;
	
	private int soLuong;
	
	public SanPhamTrongGioHang() {
		super();
	}
	public SanPhamTrongGioHang(String maChiTietSanPham, ChiTietSanPham chiTietSanPham, NguoiDung nguoiDung, int soLuong) {
		super();
		this.maSanPhamTrongGioHang = maChiTietSanPham;
		this.chiTietSanPham = chiTietSanPham;
		this.nguoiDung = nguoiDung;
		this.soLuong = soLuong;
	}
	
	public ChiTietSanPham getChiTietSanPham() {
		return chiTietSanPham;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public int getSoLuong() {
		return soLuong;
	}
	 @JsonProperty
	public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	 @JsonProperty
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	
	public String getMaSanPhamTrongGioHang() {
		return maSanPhamTrongGioHang;
	}
	public void setMaSanPhamTrongGioHang(String maSanPhamTrongGioHang) {
		this.maSanPhamTrongGioHang = maSanPhamTrongGioHang;
	}
	@Override
	public String toString() {
		return "SanPhamTrongGioHang [chiTietSanPham=" + chiTietSanPham + ", nguoiDung=" + nguoiDung + ", soLuong="
				+ soLuong + "]";
	}
	
	
}
