package com.se.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class ChiTietSanPham implements Serializable {
	@Id
	private String maChiTietSanPham;
	@ManyToOne
	@NotNull
	@JoinColumn(name="maSanPham")
	private SanPham sanPham ;
	@ManyToOne
	@NotNull
	@JoinColumn(name="maKichThuoc")
	private KichThuoc kichThuoc ;
	
	@OneToMany(mappedBy = "chiTietSanPham")
	private List<ChiTietDonHang> danhSachChiTietDonHang;
	
	@OneToMany(mappedBy = "chiTietSanPham")
	private List<SanPhamTrongGioHang> danhSachSanPhamTrongGioHang ;
	
	private int soLuongTon;
	
	
	public ChiTietSanPham(SanPham sanPham, KichThuoc kichThuoc, Double giaTien,
			float chietKhau, int soLuongTon) {
		super();
	
		this.kichThuoc = kichThuoc;
		this.soLuongTon = soLuongTon;
		if(sanPham != null && sanPham.getMaSanPham() != null && kichThuoc != null && kichThuoc.getMaKichThuoc() != null)
			this.maChiTietSanPham =sanPham.getMaSanPham()+kichThuoc.getMaKichThuoc();
	}
	

	public ChiTietSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaChiTietSanPham() {
		return maChiTietSanPham;
	}
	 @JsonIgnore
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		if(sanPham != null && sanPham.getMaSanPham() != null && kichThuoc != null && kichThuoc.getMaKichThuoc() != null)
			this.maChiTietSanPham =sanPham.getMaSanPham()+kichThuoc.getMaKichThuoc();
		this.sanPham = sanPham;
	}

	public KichThuoc getKichThuoc() {
		
		return kichThuoc;
	}
	public void setKichThuoc(KichThuoc kichThuoc) {
		if(sanPham != null && sanPham.getMaSanPham() != null && kichThuoc != null && kichThuoc.getMaKichThuoc() != null)
			this.maChiTietSanPham =sanPham.getMaSanPham()+kichThuoc.getMaKichThuoc();
		this.kichThuoc = kichThuoc;
	}
	 @JsonIgnore
	public List<ChiTietDonHang> getDanhSachChiTietDonHang() {
		return danhSachChiTietDonHang;
	}
	 @JsonProperty
	public void setDanhSachChiTietDonHang(List<ChiTietDonHang> danhSachChiTietDonHang) {
		this.danhSachChiTietDonHang = danhSachChiTietDonHang;
	}
	 @JsonIgnore
	public List<SanPhamTrongGioHang> getDanhSachSanPhamTrongGioHang() {
		return danhSachSanPhamTrongGioHang;
	}
	 @JsonProperty
	public void setDanhSachSanPhamTrongGioHang(List<SanPhamTrongGioHang> danhSachSanPhamTrongGioHang) {
		this.danhSachSanPhamTrongGioHang = danhSachSanPhamTrongGioHang;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}


	@Override
	public String toString() {
		return "ChiTietSanPham [maChiTietSanPham=" + maChiTietSanPham + ", sanPham=" + sanPham + ", kichThuoc="
				+ kichThuoc + ", soLuongTon=" + soLuongTon + "]";
	}
		
}
