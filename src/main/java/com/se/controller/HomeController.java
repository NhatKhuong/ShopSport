package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NguoiDung;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;

@Controller
public class HomeController {

	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	
	@GetMapping("/")
	public String showHome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		NguoiDung nguoiDung = nguoiDungService.getByEmail(username);
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 5, 1000000000, 125, 10);
//		List<SanPham> list = sanPhamService.getByFilter("", "", "", 5, 1000000000, 1, 6);
		model.addAttribute("listSanPham", list);
		model.addAttribute("UserLogin",nguoiDung);
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
