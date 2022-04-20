package com.se.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuanLySanPhamController {
	@RequestMapping("/quan-ly/quan-ly-san-pham")
	public String quanLyDonHang() {
		return "admin/quanLySanPham";
	}
	@RequestMapping("/quan-ly/them-san-pham")
	public String themSanPham() {
		return "admin/themSanPham";
	}
	
}
