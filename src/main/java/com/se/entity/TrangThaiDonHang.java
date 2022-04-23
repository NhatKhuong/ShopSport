package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class TrangThaiDonHang {
	@Id
	private String  maTrangThaiDonHang ;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String  tenTrangThaiDonHang ;
	
	@OneToMany(mappedBy = "trangThaiDonHang")
	private List<DonHang> danhSachDonHang;
	
	public TrangThaiDonHang(String maTrangThaiDonHang, String tenTrangThaiDonHang) {
		super();
		this.maTrangThaiDonHang = maTrangThaiDonHang;
		this.tenTrangThaiDonHang = tenTrangThaiDonHang;
	}
	public TrangThaiDonHang(String maTrangThaiDonHang) {
		super();
		this.maTrangThaiDonHang = maTrangThaiDonHang;
	}

	public TrangThaiDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMaTrangThaiDonHang() {
		return maTrangThaiDonHang;
	}
	public void setMaTrangThaiDonHang(String maTrangThaiDonHang) {
		this.maTrangThaiDonHang = maTrangThaiDonHang;
	}
	public String getTenTrangThaiDonHang() {
		return tenTrangThaiDonHang;
	}
	public void setTenTrangThaiDonHang(String tenTrangThaiDonHang) {
		this.tenTrangThaiDonHang = tenTrangThaiDonHang;
	}
	
	@JsonIgnore
	public List<DonHang> getDanhSachDonHang() {
		return danhSachDonHang;
	}
	@JsonProperty
	public void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
		this.danhSachDonHang = danhSachDonHang;
	}
	@Override
	public String toString() {
		return "TrangThaiDonHang [maTrangThaiDonHang=" + maTrangThaiDonHang + ", tenTrangThaiDonHang="
				+ tenTrangThaiDonHang + "]";
	}

	
}
