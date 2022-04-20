package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.entity.ChiTietDonHang;
import com.se.entity.ChiTietSanPham;
import com.se.entity.DonHang;
import com.se.entity.SanPham;
import com.se.service.ChiTietSanPhamService;
import com.se.service.SanPhamService;

@Controller
public class OrderController {
		
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;
	
	@GetMapping("/don-hang/tao-don-hang")
	public String taoDonHang(Model model) {
		
		List<String[]> listPreadcrumb = new ArrayList<String[]>();
//		 String[0] =  name page 
//		 String[1] =  href page
		listPreadcrumb.add(new String[] {"Home", ""});
		listPreadcrumb.add(new String[] {"Đơn hàng", "/don-hang"});
		listPreadcrumb.add(new String[] {"Mua hàng", ""});
		model.addAttribute("listPreadcrumb", listPreadcrumb);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  String username =  null;
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		
		List<ChiTietSanPham> danhSachChiTietSanPham =  new ArrayList<ChiTietSanPham>();
		ChiTietSanPham ct1 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00093", "KT00000");
		ChiTietSanPham ct2 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00080", "KT00000");
		ChiTietSanPham ct3 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00083", "KT00000");
//		ChiTietSanPham ct4 = chiTietSanPhamService.getChiTiZetSanPhamByMaSanPhamMaKichThuoc("SPAA00058", "KT00000");
		ChiTietSanPham ct5 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00062", "KT00000");
		ChiTietSanPham ct6 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00055", "KT00000");
//		DonHang donHang = new 
//		List<ChiTietDonHang> danhSachChiTietDonHang = new ArrayList<ChiTietDonHang>();
//		danhSachChiTietDonHang.add(new ChiTietDonHang());
		model.addAttribute("danhSachChiTietSanPham",danhSachChiTietSanPham);
		
		return "createOrder";
	}
}
