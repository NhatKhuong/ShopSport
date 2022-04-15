package com.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorityController {
	@GetMapping("/dang-nhap")
	public String hienTrangDangNhap() {
		return "dangNhap";
	}
	@GetMapping("/dang-ky")
	public String hienTrangDangKy() {
		return "dangKy";
	}
	
	@GetMapping("/quanly")
	public String showAdminPage() {
		return "quanLy";
	}
	
	@GetMapping("/access-denied")
	public String showDeniedPage() {
		return "denied";
	}
}
