package com.se.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaoCaoDoanhThuController {
	@RequestMapping("/quan-ly/bao-cao-doanh-thu")
	public String showQuanLyDonHang() {
		return "admin/baoCaoDoanhThu";
	}
}

