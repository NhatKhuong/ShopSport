package com.se.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class HinhAnhSanPham {
	@Id
	private String maHinhAnh;
	@ManyToOne
	@NotNull
	@JoinColumn(name="maSanPham")
	private SanPham sanPham;
	@Column(columnDefinition = "nvarchar(255)")
	private String hinhAnh ;
	
	public HinhAnhSanPham(String maHinhAnh, SanPham sanPham, String hinhAnh) {
		super();
		this.maHinhAnh = maHinhAnh;
		this.sanPham = sanPham;
		this.hinhAnh = hinhAnh;
	}
	public HinhAnhSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HinhAnhSanPham(String maHinhAnh) {
		// TODO Auto-generated constructor stub
		this.maHinhAnh = maHinhAnh;
	}
	public String getMaHinhAnh() {
		return maHinhAnh;
	}
	public void setMaHinhAnh(String maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}
	@JsonIgnore
	public SanPham getSanPham() {
		return sanPham;
	}
	@JsonProperty
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "HinhAnhSanPham [maHinhAnh=" + maHinhAnh + ", sanPham=" + sanPham + ", hinhAnh=" + hinhAnh + "]";
	}
	
	
}
