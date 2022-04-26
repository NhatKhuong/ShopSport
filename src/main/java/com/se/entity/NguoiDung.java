package com.se.entity;

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
public class NguoiDung {
	@Id
	private String maNguoiDung;
	@ManyToOne
	@JoinColumn(name = "maDiaChi")
	@NotNull
	private DiaChi diaChi;
	@OneToMany(mappedBy = "nguoiDung")
	private List<DonHang> danhSachDonHang;
	@OneToMany(mappedBy = "nguoiDung")

	@JsonIgnore
	private List<SanPhamTrongGioHang> danhSachSanPhamTrongGioHang;
	@OneToMany(mappedBy = "nguoiDung")
	private List<DanhGia> danhSachDanhGia;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String hoTen;
	@Column(columnDefinition = "nvarchar(255)")
	private String diaChiChiTiet;
	@NotNull
	private String email;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String matKhau;
	private boolean gioiTinh;
	private boolean trangThai;
	private String soDienThoai;

	public NguoiDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NguoiDung(String maNguoiDung, @NotNull DiaChi diaChi, @NotNull String hoTen, String diaChiChiTiet,
			@NotNull String email, @NotNull String matKhau, boolean gioiTinh, boolean trangThai, String soDienThoai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.diaChi = diaChi;
		this.hoTen = hoTen;
		this.diaChiChiTiet = diaChiChiTiet;
		this.email = email;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.trangThai = trangThai;
		this.soDienThoai = soDienThoai;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	@JsonIgnore
	public List<DonHang> getDanhSachDonHang() {
		return danhSachDonHang;
	}

	@JsonProperty
	public void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
		this.danhSachDonHang = danhSachDonHang;
	}

	public List<SanPhamTrongGioHang> getDanhSachSanPhamTrongGioHang() {
		return danhSachSanPhamTrongGioHang;
	}

	public void setDanhSachSanPhamTrongGioHang(List<SanPhamTrongGioHang> danhSachSanPhamTrongGioHang) {
		this.danhSachSanPhamTrongGioHang = danhSachSanPhamTrongGioHang;
	}
	@JsonIgnore
	public List<DanhGia> getDanhSachDanhGia() {
		return danhSachDanhGia;
	}
	@JsonProperty
	public void setDanhSachDanhGia(List<DanhGia> danhSachDanhGia) {
		this.danhSachDanhGia = danhSachDanhGia;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChiChiTiet() {
		return diaChiChiTiet;
	}

	public void setDiaChiChiTiet(String diaChiChiTiet) {
		this.diaChiChiTiet = diaChiChiTiet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "NguoiDung [maNguoiDung=" + maNguoiDung + ", diaChi=" + diaChi + ", hoTen=" + hoTen + ", diaChiChiTiet="
				+ diaChiChiTiet + ", email=" + email + ", matKhau=" + matKhau + ", gioiTinh=" + gioiTinh
				+ ", trangThai=" + trangThai + "]";
	}

}
