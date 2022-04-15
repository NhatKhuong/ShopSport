package com.se.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
/*
 * createdAt: 04/10/2022
 * */
@Entity
public class MonTheThao {
	@Id
	private String maMonTheThao;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String tenMonTheThao;
	
	@OneToMany(mappedBy = "monTheThao")
	private List<SanPham> danhSachSanPham;
	
	public MonTheThao(String maMonTheThao, String tenMonTheThao) {
		super();
		this.maMonTheThao = maMonTheThao;
		this.tenMonTheThao = tenMonTheThao;
	}
	public MonTheThao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaMonTheThao() {
		return maMonTheThao;
	}

	public void setMaMonTheThao(String maMonTheThao) {
		this.maMonTheThao = maMonTheThao;
	}

	public String getTenMonTheThao() {
		return tenMonTheThao;
	}

	public void setTenMonTheThao(String tenMonTheThao) {
		this.tenMonTheThao = tenMonTheThao;
	}

	

	@Override
	public String toString() {
		return "MonTheThao [maMonTheThao=" + maMonTheThao + ", tenMonTheThao=" + tenMonTheThao + "]";
	}
	
}
