package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
 * createdAt: 04/10/2022
 * */
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class LoaiKichThuoc {
	@Id
	private String maLoaiKichThuoc;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenLoaiKichThuoc;
	
	@OneToMany(mappedBy = "loaiKichThuoc",fetch = FetchType.EAGER)
	private List<KichThuoc> danhSachKichThuoc;
	
	
	public LoaiKichThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiKichThuoc(String maLoaiKichThuoc, String tenLoaiKichThuoc) {
		super();
		this.maLoaiKichThuoc = maLoaiKichThuoc;
		this.tenLoaiKichThuoc = tenLoaiKichThuoc;
	}
	public String getMaLoaiKichThuoc() {
		return maLoaiKichThuoc;
	}
	public void setMaLoaiKichThuoc(String maLoaiKichThuoc) {
		this.maLoaiKichThuoc = maLoaiKichThuoc;
	}
	public String getTenLoaiKichThuoc() {
		return tenLoaiKichThuoc;
	}
	public void setTenLoaiKichThuoc(String tenLoaiKichThuoc) {
		this.tenLoaiKichThuoc = tenLoaiKichThuoc;
	}
	@JsonIgnore
	public List<KichThuoc> getDanhSachKichThuoc() {
		return danhSachKichThuoc;
	}
	@JsonProperty
	public void setDanhSachKichThuoc(List<KichThuoc> danhSachKichThuoc) {
		this.danhSachKichThuoc = danhSachKichThuoc;
	}
	@Override
	public String toString() {
		return "LoaiKichThuoc [maLoaiKichThuoc=" + maLoaiKichThuoc + ", tenLoaiKichThuoc=" + tenLoaiKichThuoc + "]";
	}
	
}
