package com.se.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
// @PropertySource({"classpath:value-mssql.properties"})
public class DonHang {

	@Id
	private String maDonHang;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "maNguoiDung")
	private NguoiDung nguoiDung;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "maDiaChi")
	private DiaChi diaChi;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "maTrangThaiDonHang")
	private TrangThaiDonHang trangThaiDonHang;

	@OneToMany(mappedBy = "donHang", fetch = FetchType.EAGER)
	private List<ChiTietDonHang> danhSachChiTietDonHang;
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull
	private String diaChiCuThe;
	private Date ngayTao;
	private Date ngayGiao;
	private double phiVanChuyen;
	@Column(columnDefinition = "varchar(11)")
	private String soDienThoai;

	public DonHang(@NotNull NguoiDung nguoiDung, @NotNull DiaChi diaChi,
			@NotNull TrangThaiDonHang trangThaiDonHang, List<ChiTietDonHang> danhSachChiTietDonHang,
			@NotNull String diaChiCuThe, Date ngayTao, Date ngayGiao, double phiVanChuyen, String soDienThoai) {
		super();
		this.nguoiDung = nguoiDung;
		this.diaChi = diaChi;
		this.trangThaiDonHang = trangThaiDonHang;
		this.danhSachChiTietDonHang = danhSachChiTietDonHang;
		this.diaChiCuThe = diaChiCuThe;
		this.ngayTao = ngayTao;
		this.ngayGiao = ngayGiao;
		this.phiVanChuyen = phiVanChuyen;
		this.soDienThoai = soDienThoai;
	}
	

	public DonHang(String maDonHang) {
		super();
		this.maDonHang = maDonHang;
	}


	public DonHang(@NotNull NguoiDung nguoiDung, List<ChiTietDonHang> danhSachChiTietDonHang,
			TrangThaiDonHang trangThaiDonHang,
			Date ngayGiao, double phiVanChuyen) {
		this.nguoiDung = nguoiDung;
		this.danhSachChiTietDonHang = danhSachChiTietDonHang;
		this.ngayGiao = ngayGiao;
		this.phiVanChuyen = phiVanChuyen;
		// value default
		this.ngayTao = new Date();
		this.trangThaiDonHang = trangThaiDonHang;
		if (nguoiDung != null) {
			this.diaChi = nguoiDung.getDiaChi();
			this.diaChiCuThe = nguoiDung.getDiaChiChiTiet();
			this.soDienThoai = nguoiDung.getSoDienThoai();
		}
	}

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public TrangThaiDonHang getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(TrangThaiDonHang trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	@JsonIgnore
	public List<ChiTietDonHang> getDanhSachChiTietDonHang() {
		return danhSachChiTietDonHang;
	}
	
	@JsonProperty
	public void setDanhSachChiTietDonHang(List<ChiTietDonHang> danhSachChiTietDonHang) {
		this.danhSachChiTietDonHang = danhSachChiTietDonHang;
	}

	public String getDiaChiCuThe() {
		return diaChiCuThe;
	}

	public void setDiaChiCuThe(String diaChiCuThe) {
		this.diaChiCuThe = diaChiCuThe;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public double getPhiVanChuyen() {
		return phiVanChuyen;
	}

	public void setPhiVanChuyen(double phiVanChuyen) {
		this.phiVanChuyen = phiVanChuyen;
	}

	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", nguoiDung=" + nguoiDung + ", diaChi=" + diaChi
				+ ", trangThaiDonHang=" + trangThaiDonHang 
				+ ", diaChiCuThe=" + diaChiCuThe + ", ngayTao=" + ngayTao + ", ngayGiao=" + ngayGiao + ", phiVanChuyen="
				+ phiVanChuyen + "]";
	}

	public double tongTienDonHang() {
		double sum = 0;

		if (danhSachChiTietDonHang != null) {
			for (ChiTietDonHang chiTietDonHang : danhSachChiTietDonHang) {
				sum += chiTietDonHang.getGiaMua() * chiTietDonHang.getSoLuongMua();
			}
		}
		return sum;

	}

	public double tongTien() {
		return tongTienDonHang() + phiVanChuyen;
	}
}
