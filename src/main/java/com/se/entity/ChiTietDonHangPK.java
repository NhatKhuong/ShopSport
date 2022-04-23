package com.se.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chiTietSanPham;
	private String donHang;
	public String getChiTietSanPham() {
		return chiTietSanPham;
	}
	public void setChiTietSanPham(String chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	public String getDonHang() {
		return donHang;
	}
	public void setDonHang(String donHang) {
		this.donHang = donHang;
	}
	public ChiTietDonHangPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiTietSanPham == null) ? 0 : chiTietSanPham.hashCode());
		result = prime * result + ((donHang == null) ? 0 : donHang.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHangPK other = (ChiTietDonHangPK) obj;
		if (chiTietSanPham == null) {
			if (other.chiTietSanPham != null)
				return false;
		} else if (!chiTietSanPham.equals(other.chiTietSanPham))
			return false;
		if (donHang == null) {
			if (other.donHang != null)
				return false;
		} else if (!donHang.equals(other.donHang))
			return false;
		return true;
	}
	
}
