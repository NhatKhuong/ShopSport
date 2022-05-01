package com.se.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@IdClass(DanhGiaPK.class)
public class DanhGia {
	@Id 
	@ManyToOne
	@JoinColumn(name="maSanPham")
	
	private SanPham sanPham;
	@Id 
	@ManyToOne
	@JoinColumn(name="maNguoiDung")
	private NguoiDung nguoiDung;
	@NotNull
	private int xepHang;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String noiDung;
	@Column(columnDefinition = "nvarchar(255)")
	private String hinhAnh;
	private Date thoiGian;
	
	public DanhGia(SanPham sanPham, NguoiDung nguoiDung, int xepHang, String noiDung, String hinhAnh, Date thoiGian) {
		super();
		this.sanPham = sanPham;
		this.nguoiDung = nguoiDung;
		this.xepHang = xepHang;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.thoiGian = thoiGian;
	}

	public DanhGia(SanPham sanPham, NguoiDung nguoiDung) {
		super();
		this.sanPham = new SanPham();
		this.nguoiDung = nguoiDung;
	}

	public DanhGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	public SanPham getSanPham() {
		return sanPham;
	}
	@JsonProperty
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public int getXepHang() {
		return xepHang;
	}

	public void setXepHang(int xepHang) {
		this.xepHang = xepHang;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	@Override
	public String toString() {
		return "DanhGia [sanPham=" + sanPham + ", nguoiDung=" + nguoiDung + ", xepHang=" + xepHang + ", noiDung="
				+ noiDung + ", hinhAnh=" + hinhAnh + ", thoiGian=" + thoiGian + "]";
	}
	
	
	
}
