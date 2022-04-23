package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class KichThuoc {
	@Id
	private String maKichThuoc;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "maLoaiKichThuoc")
	private LoaiKichThuoc loaiKichThuoc;
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenKichThuoc;
	

	public KichThuoc(String maKichThuoc, LoaiKichThuoc loaiKichThuoc, String tenKichThuoc) {
		super();
		this.maKichThuoc = maKichThuoc;
		this.loaiKichThuoc = loaiKichThuoc;
		this.tenKichThuoc = tenKichThuoc;
	}
	
	public KichThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaKichThuoc() {
		return maKichThuoc;
	}
	public void setMaKichThuoc(String maKichThuoc) {
		this.maKichThuoc = maKichThuoc;
	}
	public LoaiKichThuoc getLoaiKichThuoc() {
		return loaiKichThuoc;
	}
	public void setLoaiKichThuoc(LoaiKichThuoc loaiKichThuoc) {
		this.loaiKichThuoc = loaiKichThuoc;
	}
	public String getTenKichThuoc() {
		return tenKichThuoc;
	}
	public void setTenKichThuoc(String tenKichThuoc) {
		this.tenKichThuoc = tenKichThuoc;
	}
	
	
	@Override
	public String toString() {
		return "KichThuoc [maKichThuoc=" + maKichThuoc + ", loaiKichThuoc=" + loaiKichThuoc + ", tenKichThuoc="
				+ tenKichThuoc + "]";
	}
	
}
