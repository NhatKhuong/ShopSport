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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.se.entity.ChiTietDonHang;
//import com.se.entity.ChiTietDonHang;
import com.se.entity.ChiTietSanPham;
import com.se.entity.DiaChi;
import com.se.entity.DonHang;
import com.se.entity.KichThuoc;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.entity.TrangThaiDonHang;
import com.se.service.ChiTietSanPhamService;import com.se.service.DiaChiService;
import com.se.service.DonHangService;
import com.se.service.KichThuocService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;
import com.se.util.User;

@Controller
@PropertySource({"classpath:value-mssql.properties"})
public class OrderController {
		
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private DiaChiService diaChiService;
	
	@Autowired
	private KichThuocService kichThuocService;
	
	@Autowired
	private DonHangService donHangService;
	
	@Autowired
	private Environment env;	
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;
	
	@GetMapping("/don-hang/tao-don-hang")
	public String hienDonHang(Model model,@ModelAttribute("donHang") DonHang donHang ) {

		List<String[]> listPreadcrumb = new ArrayList<String[]>();
		
//		 String[0] =  name page 
//		 String[1] =  href page
		listPreadcrumb.add(new String[] {"Home", ""});
		listPreadcrumb.add(new String[] {"Đơn hàng", "/don-hang"});
		listPreadcrumb.add(new String[] {"Mua hàng", ""});
		model.addAttribute("listPreadcrumb", listPreadcrumb);
	
		NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
		donHang.setNguoiDung(nguoiDung);
		
		ArrayList<ChiTietDonHang> danhSachChiTietDonHang =  new ArrayList<ChiTietDonHang>();
		if(donHang.getDanhSachChiTietDonHang() == null || donHang.getDanhSachChiTietDonHang().size() ==0) {
			return "redirect:/";
		}
		int soLuongCTHD = donHang.getDanhSachChiTietDonHang().size();
		for(int i = 0; i < soLuongCTHD; i ++) {
			ChiTietDonHang chiTietDonHang= donHang.getDanhSachChiTietDonHang().get(i);
			KichThuoc kichThuoc = kichThuocService.getKichThuocTheoTenKichThuoc(chiTietDonHang.getChiTietSanPham().getKichThuoc().getTenKichThuoc());
			ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc(chiTietDonHang.getChiTietSanPham().getSanPham().getMaSanPham(),kichThuoc.getMaKichThuoc());
			chiTietDonHang.setChiTietSanPham(chiTietSanPham);
			chiTietDonHang.setGiaMua(chiTietSanPham.getSanPham().getGiaTien()-chiTietSanPham.getSanPham().getChietKhau()/100*chiTietSanPham.getSanPham().getGiaTien());
			chiTietDonHang.setChietKhau(chiTietSanPham.getSanPham().getChietKhau());
			danhSachChiTietDonHang.add(chiTietDonHang);
		}
 		model.addAttribute("donHang",donHang);

		return "createOrder";
	}
	
	@PostMapping("/don-hang/tao-don-hang")
	public String luuDonHang(@ModelAttribute("donHang") DonHang donHang) throws Exception{
 
	donHang.setNguoiDung(nguoiDungService.getByEmail(User.getEmailNguoiDung()));
	DiaChi diaChi = donHang.getDiaChi();
	
	donHang.setDiaChi(diaChiService.getDiaChi(diaChi.getPhuongXa(),diaChi.getQuanHuyen(), diaChi.getTinhThanhPho()));

	donHang.setTrangThaiDonHang(new TrangThaiDonHang(env.getProperty("trangThaiDonHang.maChoXacNhan")));
	donHang.setNgayTao(new Date());
	boolean result = donHangService.themHoaDon(donHang);
	return "redirect:/don-hang/tao-don-hang";
	}
}
