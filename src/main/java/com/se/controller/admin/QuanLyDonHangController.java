package com.se.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuanLyDonHangController {
	@RequestMapping("/quan-ly/quan-ly-don-hang")
	public String showQuanLyDonHang() {
		return "admin/quanLyDonHang";
	}
}
