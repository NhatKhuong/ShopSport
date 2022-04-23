package com.se.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DanhGiaPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nguoiDung;
	private String sanPham;
	public DanhGiaPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(String nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	@Override
	public String toString() {
		return "DanhGiaPK [nguoiDung=" + nguoiDung + ", sanPham=" + sanPham + "]";
	}
	
}
