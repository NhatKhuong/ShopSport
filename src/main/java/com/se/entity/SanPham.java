package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.se.dao.KichThuocDao;
import com.se.service.KichThuocService;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class SanPham {
	
	@Id
	private String maSanPham;
	@ManyToOne
	@JoinColumn(name="maLoaiSanPham")
	@NotNull
	private LoaiSanPham loaiSanPham;
	@ManyToOne
	@JoinColumn(name="maMonTheThao")
	@NotNull
	private MonTheThao monTheThao ;
	@ManyToOne
	@NotNull
	@JoinColumn(name="maNhanHieu")
	private NhanHieu nhanHieu;
	
	@OneToMany(mappedBy = "sanPham", fetch = FetchType.EAGER)
	private List<HinhAnhSanPham> danhSachHinhAnhSanPham;
	
	@OneToMany(mappedBy = "sanPham")	
	private List<ChiTietSanPham> danhSachChiTietSanPham;
	
	@OneToMany(mappedBy = "sanPham")	
	private List<DanhGia> danhSachDanhGia;
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenSanPham;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String mieuTa;

	private Double giaTien ;
	private float chietKhau;
	private boolean trangThai;
	
	public SanPham() {
	
	}
	
	public SanPham(String maSanPham, @NotNull LoaiSanPham loaiSanPham, @NotNull MonTheThao monTheThao,
			@NotNull NhanHieu nhanHieu, @NotNull String tenSanPham, String mieuTa, Double giaTien, float chietKhau) {
		super();
		this.maSanPham = maSanPham;
		this.loaiSanPham = loaiSanPham;
		this.monTheThao = monTheThao;
		this.nhanHieu = nhanHieu;
		this.tenSanPham = tenSanPham;
		this.mieuTa = mieuTa;
		this.giaTien = giaTien;
		this.chietKhau = chietKhau;
	}

	

	public Double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(Double giaTien) {
		this.giaTien = giaTien;
	}

	public float getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}

	public List<HinhAnhSanPham> getDanhSachHinhAnhSanPham() {
		return danhSachHinhAnhSanPham;
	}


	public void setDanhSachHinhAnhSanPham(List<HinhAnhSanPham> danhSachHinhAnhSanPham) {
		this.danhSachHinhAnhSanPham = danhSachHinhAnhSanPham;
	}

	@JsonIgnore
	public List<ChiTietSanPham> getDanhSachChiTietSanPham() {
		return danhSachChiTietSanPham;
	}


	public void setDanhSachChiTietSanPham(List<ChiTietSanPham> danhSachChiTietSanPham) {
		this.danhSachChiTietSanPham = danhSachChiTietSanPham;
	}

	@JsonIgnore
	public List<DanhGia> getDanhSachDanhGia() {
		return danhSachDanhGia;
	}

	@JsonProperty
	public void setDanhSachDanhGia(List<DanhGia> danhSachDanhGia) {
		this.danhSachDanhGia = danhSachDanhGia;
	}


	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public MonTheThao getMonTheThao() {
		return monTheThao;
	}
	public void setMonTheThao(MonTheThao monTheThao) {
		this.monTheThao = monTheThao;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	
	public String getMieuTa() {
		return mieuTa;
	}
	public void setMieuTa(String mieuTa) {
		this.mieuTa = mieuTa;
	}
	
	
	public NhanHieu getNhanHieu() {
		return nhanHieu;
	}


	public void setNhanHieu(NhanHieu nhanHieu) {
		this.nhanHieu = nhanHieu;
	}
	
	

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", loaiSanPham=" + loaiSanPham + ", monTheThao=" + monTheThao
				+ ", nhanHieu=" + nhanHieu + ", tenSanPham=" + tenSanPham + ", giaTien="
				+ giaTien + ", chietKhau=" + chietKhau + "]";
	}
	
}
