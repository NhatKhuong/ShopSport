package com.se.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuanLyNguoiDungController {
	
	@RequestMapping("/quan-ly/quan-ly-nguoi-dung")
	public String showQuanLyNguoiDung() {
		return "admin/quanLyNguoiDung";
	}
	

}
