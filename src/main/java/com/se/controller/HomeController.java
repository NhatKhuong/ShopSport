package com.se.controller;

import java.util.Arrays;
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

import com.se.entity.ChiTietSanPham;
import com.se.entity.DonHang;
import com.se.entity.KichThuoc;
import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NguoiDung;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.ChiTietSanPhamService;
import com.se.service.DiaChiService;
import com.se.service.KichThuocService;
import com.se.service.LoaiSanPhamService;
import com.se.service.MonTheThaoService;
import com.se.service.NguoiDungService;
import com.se.service.NhanHieuService;
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

	@Autowired
	private KichThuocService kichThuocService;

	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;
	
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Autowired 
	private MonTheThaoService monTheThaoService;
	
	@Autowired
	private NhanHieuService nhanHieuService;

	@GetMapping("/")
	public String showHome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;

		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		NguoiDung nguoiDung = nguoiDungService.getByEmail(email);

		List<SanPham> list = sanPhamService.getByFilter("", "", "", 5, 1000000000, 125, 10);
		List<SanPhamTrongGioHang> dsSanPhamTrongGioHang = sanPhamTrongGioHangService
				.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		
		System.out.println(list);

		model.addAttribute("dsSanPhamTrongGioHang", dsSanPhamTrongGioHang);
		model.addAttribute("listSanPham", list);
		model.addAttribute("UserLogin", nguoiDung);

		model.addAttribute("donHang", new DonHang());
		return "home";
	}

	@GetMapping("/shop")
	public String showShop(Model model) {
		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		model.addAttribute("listSanPham", list);
		String email = User.getEmailNguoiDung();
		NguoiDung nguoiDung = nguoiDungService.getByEmail(email);
		List<SanPhamTrongGioHang> dsSanPhamTrongGioHang = sanPhamTrongGioHangService
				.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		
		
		List<LoaiSanPham> dsLoaiSanPham = loaiSanPhamService.getDanhSachTenLoaiSanPham();
		List<MonTheThao> dsMonTheThao = monTheThaoService.getDanhSachTenMonTheThao();
		List<NhanHieu> dsNhanHieu = nhanHieuService.getDanhSachThuongHieu();
		System.out.println(dsNhanHieu);
		
		model.addAttribute("dsSanPhamTrongGioHang", dsSanPhamTrongGioHang);
		model.addAttribute("dsLoaiSanPham",dsLoaiSanPham);
		model.addAttribute("dsMonTheThao",dsMonTheThao);
		model.addAttribute("dsNhanHieu",dsNhanHieu);
		
		

		return "shop";
	}

	@GetMapping("")
	public String layOut() {
		return "layout";
	}



}
