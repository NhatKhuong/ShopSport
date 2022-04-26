package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * createdAt: 04/10/2022
 * version 1.0
 */
@Entity
@IdClass(ChiTietDonHangPK.class)
public class ChiTietDonHang {
	@Id
	@ManyToOne
	@JoinColumn(name = "maChiTietSanPham")
	private ChiTietSanPham chiTietSanPham;
	@Id
	@ManyToOne
	@JoinColumn(name = "maDonHang")
	private DonHang donHang;

	private int soLuongMua;
	private double giaMua;
	private float chietKhau;

	public ChiTietDonHang(ChiTietSanPham chiTietSanPham, DonHang donHang, int soLuongMua, double giaMua,
			float chietKhau) {
		super();
		this.chiTietSanPham = chiTietSanPham;
		this.donHang = donHang;
		this.soLuongMua = soLuongMua;
		this.giaMua = giaMua;
		this.chietKhau = chietKhau;
	}

	public ChiTietDonHang(ChiTietSanPham chiTietSanPham, int soLuongMua, double giaMua, float chietKhau) {
		super();
		this.chiTietSanPham = chiTietSanPham;
		this.soLuongMua = soLuongMua;
		this.giaMua = giaMua;
		this.chietKhau = chietKhau;
	}

	public ChiTietDonHang() {
		super();
	}

	public ChiTietSanPham getChiTietSanPham() {
		return chiTietSanPham;
	}

	public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public double getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(double giaMua) {
		this.giaMua = giaMua;
	}

	public float getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [chiTietSanPham=" + chiTietSanPham + ", donHang=" + donHang + ", soLuongMua="
				+ soLuongMua + ", giaMua=" + giaMua + ", chietKhau=" + chietKhau + "]";
	}

}
