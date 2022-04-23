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
public class LoaiSanPham {
	@Id
	private String maLoaiSanPham ; 
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenLoaiSanPham;
	
	@OneToMany(mappedBy = "loaiSanPham")
	private List<SanPham> danhSachSanPham;
	
	public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
	}
	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}
	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}
	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}
	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}
	@JsonIgnore
	public List<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	@JsonProperty
	public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}
	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSanPham=" + maLoaiSanPham + ", tenLoaiSanPham=" + tenLoaiSanPham + "]";
	} 
	
}
