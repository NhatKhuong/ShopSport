package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.entity.ChiTietSanPham;
import com.se.entity.SanPham;
import com.se.service.SanPhamService;

@Controller
public class OrderController {
		
	@Autowired
	private SanPhamService sanPhamService;
	
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
		  String username;
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		
		List<SanPham> listSanPham = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		
		List<ChiTietSanPham> danhSachChiTietSanPham =  new ArrayList<ChiTietSanPham>();
		
		danhSachChiTietSanPham.add(new ChiTietSanPham(null, null, null, 0, 0));
		
		return "createOrder";
	}
}
