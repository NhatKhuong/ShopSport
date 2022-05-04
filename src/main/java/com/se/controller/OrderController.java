package com.se.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.se.service.TrangThaiDonHangService;
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
	
	@Autowired
	private TrangThaiDonHangService trangThaiDonHangService;
	
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
	public String luuDonHang(@ModelAttribute("donHang") DonHang donHang, Model model) throws Exception{
 
	donHang.setNguoiDung(nguoiDungService.getByEmail(User.getEmailNguoiDung()));
	DiaChi diaChi = donHang.getDiaChi();
	
	donHang.setDiaChi(diaChiService.getDiaChi(diaChi.getPhuongXa(),diaChi.getQuanHuyen(), diaChi.getTinhThanhPho()));

	donHang.setTrangThaiDonHang(new TrangThaiDonHang(env.getProperty("trangThaiDonHang.maChoXacNhan")));
	donHang.setNgayTao(new Date());
	boolean result = donHangService.themHoaDon(donHang);
	return "redirect:/don-hang/tao-don-hang";
	}
	
	@GetMapping({"/don-hang/danh-sach-don-hang/{maTrangThaiDonHang}", "/don-hang/danh-sach-don-hang"})
	public String showOrderStatus(Model model, HttpServletRequest request ,@PathVariable  (value="maTrangThaiDonHang",required = false) String maTrangThaiDonHang ) {
		int page = 1 ,limit = 5;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			limit = Integer.parseInt(request.getParameter("limit"));
			if(page <0)
				page =1;
		} catch (Exception e) {
			
		}
		List<DonHang> danhSachDonHang= donHangService.layDanhSachDonHang(page, limit, maTrangThaiDonHang);
		int tongSoDonHang = donHangService.layTongDonHangTheoTrangThai(maTrangThaiDonHang);
		int tongSoTrang  = tongSoDonHang % limit == 0  ? tongSoDonHang/limit : tongSoDonHang/limit+1;
		List<TrangThaiDonHang> danhSachTrangThaiDonHang = trangThaiDonHangService.layDanhSachTrangThaiDonHang();
		model.addAttribute("danhSachDonHang",danhSachDonHang);
		model.addAttribute("danhSachTrangThaiDonHang",danhSachTrangThaiDonHang);
		model.addAttribute("tongSoTrang",tongSoTrang == 0 ? 1 : tongSoTrang );
		model.addAttribute("page",page);
		
		return "danhSachDonHang";
	}
	@GetMapping({"/don-hang/chi-tiet-don-hang/{maDonHang}"})
	public String showChiTietDonHang(Model model, HttpServletRequest request ,@PathVariable  (value="maDonHang",required = true) String maDonHang ) {
		DonHang donHang = donHangService.getDonHangById(maDonHang);
		model.addAttribute("donHang",donHang);
 
		return "chiTietDonHang";
	}
}
