package com.se.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.entity.ChiTietDonHang;
//import com.se.entity.ChiTietDonHang;
import com.se.entity.ChiTietSanPham;
import com.se.entity.DonHang;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.entity.TrangThaiDonHang;
import com.se.service.ChiTietSanPhamService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;

@Controller
@PropertySource({"classpath:value-mssql.properties"})
public class OrderController {
		
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private Environment env;	
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
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
		String email;
		if (principal instanceof UserDetails) {
			email = ((UserDetails)principal).getUsername();
		} else {
			email = principal.toString();
		}
		NguoiDung nguoiDung = nguoiDungService.getByEmail(email);
		
		ChiTietSanPham ct1 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00093", "KT00000");
		ChiTietSanPham ct2 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00080", "KT00000");
		ChiTietSanPham ct3 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00083", "KT00000");
		ChiTietSanPham ct4 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00058", "KT00000");
		ChiTietSanPham ct5 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00062", "KT00000");
		ChiTietSanPham ct6 = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc("SPAA00055", "KT00000");
		List<ChiTietDonHang> list =  new ArrayList<ChiTietDonHang>();
		DonHang donHang = new DonHang(nguoiDung,list, new TrangThaiDonHang( env.getProperty("hibernate.dialect")) , new Date(), 0);
		list.add(new ChiTietDonHang(ct1, 10,ct1.getSanPham().getGiaTien() - ct1.getSanPham().getGiaTien() * ct1.getSanPham().getChietKhau()/100,ct1.getSanPham().getChietKhau()));
		list.add(new ChiTietDonHang(ct2, 3,ct2.getSanPham().getGiaTien() - ct2.getSanPham().getGiaTien() * ct2.getSanPham().getChietKhau()/100,ct2.getSanPham().getChietKhau()));
		list.add(new ChiTietDonHang(ct3, 7,ct3.getSanPham().getGiaTien() - ct3.getSanPham().getGiaTien() * ct3.getSanPham().getChietKhau()/100,ct3.getSanPham().getChietKhau()));
		list.add(new ChiTietDonHang(ct4, 1,ct4.getSanPham().getGiaTien() - ct4.getSanPham().getGiaTien() * ct4.getSanPham().getChietKhau()/100,ct4.getSanPham().getChietKhau()));
		list.add(new ChiTietDonHang(ct5, 2,ct5.getSanPham().getGiaTien() - ct5.getSanPham().getGiaTien() * ct5.getSanPham().getChietKhau()/100,ct5.getSanPham().getChietKhau()));
		list.add(new ChiTietDonHang(ct6, 6,ct6.getSanPham().getGiaTien() - ct6.getSanPham().getGiaTien() * ct6.getSanPham().getChietKhau()/100,ct6.getSanPham().getChietKhau()));
		model.addAttribute("donHang",donHang);
		
		System.err.println(donHang.getDanhSachChiTietDonHang());
		return "createOrder";
	}
}
