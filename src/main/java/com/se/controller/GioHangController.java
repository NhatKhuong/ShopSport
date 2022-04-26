package com.se.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.ChiTietSanPham;
import com.se.entity.KichThuoc;
import com.se.entity.NguoiDung;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.ChiTietSanPhamService;
import com.se.service.KichThuocService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamTrongGioHangService;
import com.se.util.User;

@Controller
public class GioHangController {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private KichThuocService kichThuocService;
	
	@Autowired
	private SanPhamTrongGioHangService sanPhamTrongGioHangService;
	
	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;
	
	
	@RequestMapping(value = "/gio-hang/san-pham", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<SanPhamTrongGioHang> sanPhamTrongGioHang(HttpServletRequest request)  {
		
		NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
		List<SanPhamTrongGioHang> list = sanPhamTrongGioHangService.getDSSanPhamTrongGioHangTheoMaNguoiDung(nguoiDung.getMaNguoiDung());
		return list;
	}

	
	@RequestMapping(value = "/gio-hang/them", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themSanPhamGioHang(HttpServletRequest request)  {
		System.out.println(1);
		String tenKichThuoc = request.getParameter("tenKichThuoc");
		System.out.println(tenKichThuoc);
		System.out.println(request.getParameter("soLuong"));
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		String maSanPham = request.getParameter("productId");
		
		
		KichThuoc kichThuoc = kichThuocService.getKichThuocTheoTenKichThuoc(tenKichThuoc);
		ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc(maSanPham, kichThuoc.getMaKichThuoc());	
		NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
		String id = nguoiDung.getMaNguoiDung()+chiTietSanPham.getMaChiTietSanPham();
		
		SanPhamTrongGioHang sanPhamTrongGioHang = sanPhamTrongGioHangService.getById(id);
		if(sanPhamTrongGioHang != null) {
			sanPhamTrongGioHang.setSoLuong(sanPhamTrongGioHang.getSoLuong()+soLuong);
			sanPhamTrongGioHangService.update(sanPhamTrongGioHang);
		} else {			
			sanPhamTrongGioHangService.add(new SanPhamTrongGioHang(id,chiTietSanPham, nguoiDung, soLuong));
		}
		
		return "add success";
	}
	
	@RequestMapping(value = "/gio-hang/update_quatity", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String updateQuantityWhenChange(HttpServletRequest request) {
		String maSanPhamTrongGioHang = request.getParameter("maSanPham");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
		SanPhamTrongGioHang sanPhamTrongGioHang = sanPhamTrongGioHangService.getById(maSanPhamTrongGioHang);
		sanPhamTrongGioHang.setSoLuong(soLuong);
		sanPhamTrongGioHangService.update(sanPhamTrongGioHang);
		return "update success!";				
	}
	
	@RequestMapping(value = "/gio-hang/delete", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String delete(HttpServletRequest request) {
		String maSanPhamTrongGioHang = request.getParameter("maSanPhamTrongGioHang");
		sanPhamTrongGioHangService.delete(maSanPhamTrongGioHang);		
		return "detele success!";	
	}
}
