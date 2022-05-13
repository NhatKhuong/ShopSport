package com.se.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.se.entity.SanPham;
import com.se.service.ThongKeDonHangService;

@Controller
public class DoanhThuController {
	@Autowired
	private ThongKeDonHangService thongKeDonHangService;
	
	private String ngayBatDau,ngayKetThuc;
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/bao-cao-doanh-thu-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<String> reload(HttpServletRequest req) {
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = new Date();
		if(ngayBatDau.equals("")) {
			ngayBatDau = "1990-1-1";
		}
		if(ngayKetThuc.equals("")) {
			ngayKetThuc = format.format(ngayHienTai).toString();
		}
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		int soDonHang = thongKeDonHangService.soDonHangTrongKhoangNgay(ngayBatDau, ngayKetThuc);
		List<String> list  = new ArrayList<String>();
		String soDonHangStr = soDonHang + "";
		int soDonHangThanhCong = thongKeDonHangService.soDonHangThanhCong(ngayBatDau, ngayKetThuc);
		String soDonHangThanhCongStr = soDonHangThanhCong +"";
		list.add(soDonHangStr);
		list.add(soDonHangThanhCongStr);
		double tienThuNhapNew = Math.round(thongKeDonHangService.soTienThuNhap(ngayBatDau, ngayKetThuc));
		String tienThuNhapStr = decimalFormat.format(tienThuNhapNew) + "";		
		list.add(tienThuNhapStr);
		int soDonHangChoXacNhan = thongKeDonHangService.CountDonHangChoXacNhan(ngayBatDau, ngayKetThuc);
		String soDonHangChoXacNhanStr = soDonHangChoXacNhan + "";
		list.add(soDonHangChoXacNhanStr);
		int soDonHangHuy = thongKeDonHangService.CountDonHangHuy(ngayBatDau, ngayKetThuc);
		String soDonHangHuyStr = soDonHangHuy + "";
		list.add(soDonHangHuyStr);
		return list;
	}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/bao-cao-doanh-thu-san-pham-ban-chay-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<SanPham> reloadSanPhamBanChayTable(HttpServletRequest req) {
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = new Date();
		if(ngayBatDau.equals("")) {
			ngayBatDau = "1990-1-1";
		}
		if(ngayKetThuc.equals("")) {
			ngayKetThuc = format.format(ngayHienTai).toString();
		}
		List<SanPham> listSanPhamBanChay = thongKeDonHangService.listSanPhamBanChay(ngayBatDau,ngayKetThuc);
		return listSanPhamBanChay;
	}
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/bao-cao-doanh-thu-tong-don-hang-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<?> reloadTongDonHangTable(HttpServletRequest req) {
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = new Date();
		if(ngayBatDau.equals("")) {
			ngayBatDau = "1990-1-1";
		}
		if(ngayKetThuc.equals("")) {
			ngayKetThuc = format.format(ngayHienTai).toString();
		}
		List<?> listDonHangBan = thongKeDonHangService.listHoaDonBan(ngayBatDau,ngayKetThuc,0,10);
		return listDonHangBan;
	}
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/thong-ke-theo-nam", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<?> thongKeTheoNam(HttpServletRequest req) {
		String namThongKe = req.getParameter("namThongKe");
		List<?> listThongKe = thongKeDonHangService.listThongKe(namThongKe);
		return listThongKe;
	}
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/thong-ke-tong-don-hang-load-page", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<?> reloadTrangTongDonHang(HttpServletRequest req) {
		String number = req.getParameter("number");
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = new Date();
		if(ngayBatDau.equals("")) {
			ngayBatDau = "1990-1-1";
		}
		if(ngayKetThuc.equals("")) {
			ngayKetThuc = format.format(ngayHienTai).toString();
		}
		int soPage = Integer.parseInt(number);
		List<?> listDonHangBan = thongKeDonHangService.listHoaDonBan(ngayBatDau,ngayKetThuc,soPage-1,10);
		
		return listDonHangBan;
	}
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/bao-cao-doanh-thu-load_button", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<Integer> reloadButtonTableBanHang(HttpServletRequest req) {
		String number = req.getParameter("number");
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = new Date();
		if(ngayBatDau.equals("")) {
			ngayBatDau = "1990-1-1";
		}
		if(ngayKetThuc.equals("")) {
			ngayKetThuc = format.format(ngayHienTai).toString();
		}
		int soDonHang = thongKeDonHangService.soDonHangTrongKhoangNgay(ngayBatDau,ngayKetThuc);
		int sopage = soDonHang/10;
		if(soDonHang%10>0) {
			sopage++;
		}
		List<Integer> listSoTrang = new ArrayList<Integer>();
		for(int i = 1 ; i <= sopage ; i++) {
			listSoTrang.add(i);
		}
		return listSoTrang;
	}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/thong-ke-tong-don-hang-load-page-sp", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<?> reloadTrangSP(HttpServletRequest req) {
		String number = req.getParameter("number");
		int soPage = Integer.parseInt(number);
		List<?> listsanPhamHetHang = thongKeDonHangService.listSanPhamHetHang(soPage-1,10);
		return listsanPhamHetHang;
	}
}
