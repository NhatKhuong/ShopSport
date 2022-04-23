package com.se.entity;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SanPhamTrongGioHangPK  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nguoiDung;
	private String chiTietSanPham;
	public SanPhamTrongGioHangPK() {
		super();
	}
	public String getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(String nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public String getChiTietSanPham() {
		return chiTietSanPham;
	}
	public void setChiTietSanPham(String chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	@Override
	public String toString() {
		return "SanPhamTrongGioHangPK [nguoiDung=" + nguoiDung + ", chiTietSanPham=" + chiTietSanPham + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiTietSanPham == null) ? 0 : chiTietSanPham.hashCode());
		result = prime * result + ((nguoiDung == null) ? 0 : nguoiDung.hashCode());
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
		SanPhamTrongGioHangPK other = (SanPhamTrongGioHangPK) obj;
		if (chiTietSanPham == null) {
			if (other.chiTietSanPham != null)
				return false;
		} else if (!chiTietSanPham.equals(other.chiTietSanPham))
			return false;
		if (nguoiDung == null) {
			if (other.nguoiDung != null)
				return false;
		} else if (!nguoiDung.equals(other.nguoiDung))
			return false;
		return true;
	}
	
}

