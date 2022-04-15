package com.se.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhanQuyen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String quyen;
	@Id
	@ManyToOne
	@JoinColumn(name="maNguoiDung")
	private NguoiDung nguoiDung;
	public PhanQuyen(String quyen, NguoiDung nguoiDung) {
		super();
		this.quyen = quyen;
		this.nguoiDung = nguoiDung;
	}
	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	@Override
	public String toString() {
		return "PhanQuyen [quyen=" + quyen + ", nguoiDung=" + nguoiDung + "]";
	}
	
}
