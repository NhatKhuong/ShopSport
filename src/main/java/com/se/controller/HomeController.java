package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.service.CustomerService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;

@Controller
public class HomeController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	
	@GetMapping("/")
	public String showHome(Model model) {
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 4);
		model.addAttribute("listSanPham", list);
		return "home";
	}
	
	@GetMapping("/shop")
	public String showShop(Model model) {
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		model.addAttribute("listSanPham", list);
		return "shop";
	}
	
	@GetMapping("")
	public String layOut() {
		return "layout";
	}
	
	@GetMapping("/trang-thai-don-hang")
	public String showOrderStatus(Model model) {
		
		return "trangthaidonhang";
	}
	

}
