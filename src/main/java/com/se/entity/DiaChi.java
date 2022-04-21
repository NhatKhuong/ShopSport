package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class DiaChi {
	@Id
	@Column(columnDefinition = "nvarchar(255)")
	private String maDiaChi;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tinhThanhPho;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String quanHuyen;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String phuongXa;
//	@OneToMany(mappedBy = "diaChi")
//	private List<NguoiDung> danhSachNguoiDung;
//	@OneToMany(mappedBy = "diaChi")
//	private List<DonHang> danhSachDonHang ;
	
	public DiaChi(String maDiaChi, String tinhThanhPho, String quanHuyen, String phuongXa) {
		super();
		this.maDiaChi = maDiaChi;
		this.tinhThanhPho = tinhThanhPho;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
	}
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDiaChi() {
		return maDiaChi;
	}
	public void setMaDiaChi(String maDiaChi) {
		this.maDiaChi = maDiaChi;
	}
	public String getTinhThanhPho() {
		return tinhThanhPho;
	}
	public void setTinhThanhPho(String tinhThanhPho) {
		this.tinhThanhPho = tinhThanhPho;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public String getPhuongXa() {
		return phuongXa;
	}
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	
	
	@Override
	public String toString() {
		return "DiaChi [maDiaChi=" + maDiaChi + ", tinhThanhPho=" + tinhThanhPho + ", quanHuyen=" + quanHuyen
				+ ", phuongXa=" + phuongXa + "]";
	}
	
	
}
