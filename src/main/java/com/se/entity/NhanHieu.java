package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class NhanHieu {
	@Id
	private String maNhanHieu;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenNhanHieu;
//	@OneToMany(mappedBy = "nhanHieu")
//	private List<SanPham> danhSachSanPham;
	public NhanHieu(String maNhanHieu, String tenNhanHieu) {
		super();
		this.maNhanHieu = maNhanHieu;
		this.tenNhanHieu = tenNhanHieu;
	}
	public NhanHieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanHieu() {
		return maNhanHieu;
	}
	public void setMaNhanHieu(String maNhanHieu) {
		this.maNhanHieu = maNhanHieu;
	}
	public String getTenNhanHieu() {
		return tenNhanHieu;
	}
	public void setTenNhanHieu(String tenNhanHieu) {
		this.tenNhanHieu = tenNhanHieu;
	}
	
//	@JsonIgnore
//	public List<SanPham> getDanhSachSanPham() {
//		return danhSachSanPham;
//	}
//	@JsonProperty
//	public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
//		this.danhSachSanPham = danhSachSanPham;
//	}
	@Override
	public String toString() {
		return "NhanHieu [maNhanHieu=" + maNhanHieu + ", tenNhanHieu=" + tenNhanHieu + ", danhSachSanPham="
				 + "]";
	}
	
	
}
