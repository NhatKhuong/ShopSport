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
//		System.out.println(customerService.getCustomerById(1));
//		LoaiSanPham loaiSanPham = new LoaiSanPham("loaisp1", "tenloaisp1");
//		MonTheThao monTheThao = new MonTheThao("mamontt1", "tenmontt1");
//		SanPham sanPham = new SanPham("SPAA00005",new LoaiSanPham("LSP00001", "Quần áo"),new MonTheThao("MTT00001", "Đá banh"), "Ao da bong cao cap", "Ao da bong cao cap mo ta",new NhanHieu("NH00002", "Adidas"));
//		sanPhamService.them(sanPham);
//		System.out.println(nguoiDungService.getAll());
//		System.out.println(sanPhamService.getAll());
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		model.addAttribute("listSanPham", list);
		return "home";
	}
	

}
