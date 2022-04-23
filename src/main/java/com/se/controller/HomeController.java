package com.se.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NguoiDung;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.DiaChiService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;
import com.se.service.SanPhamTrongGioHangService;
import com.se.util.User;

@Controller
public class HomeController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired 
	private SanPhamTrongGioHangService sanPhamTrongGioHangService;
	
	@Autowired
	private DiaChiService diaChiService;

	@GetMapping("/")
	public String showHome(Model model) {
		
		System.out.println(diaChiService.getDanhSachTinhThanhPho());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		
		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		NguoiDung nguoiDung = nguoiDungService.getByEmail(email);
		
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 5, 1000000000, 125, 10);
		List<SanPhamTrongGioHang> dsSanPhamTrongGioHang = sanPhamTrongGioHangService.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		
		model.addAttribute("dsSanPhamTrongGioHang",dsSanPhamTrongGioHang);
		model.addAttribute("listSanPham", list);
		model.addAttribute("UserLogin", nguoiDung);
		
		return "home";

	}

	@GetMapping("/shop")
	public String showShop(Model model) {
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		model.addAttribute("listSanPham", list);
		String email = User.getEmailNguoiDung();
		NguoiDung nguoiDung = nguoiDungService.getByEmail(email);
		List<SanPhamTrongGioHang> dsSanPhamTrongGioHang = sanPhamTrongGioHangService.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		model.addAttribute("dsSanPhamTrongGioHang",dsSanPhamTrongGioHang);
		
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
	
	@ResponseBody
	@JsonIgnoreProperties
	@RequestMapping(value = "/gio-hang/san-pham", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<SanPhamTrongGioHang> sanPhamTrongGioHang(HttpServletRequest request)  {
		
		NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
		List<SanPhamTrongGioHang> list = sanPhamTrongGioHangService.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		System.out.println(list);
		return list;
		
	}

}
