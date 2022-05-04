package com.se.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
}
