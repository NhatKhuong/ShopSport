package com.se.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/quan-ly")
	public String showQuanLyDonHang() {
		return "admin/baoCaoDoanhThu";
	}
}
