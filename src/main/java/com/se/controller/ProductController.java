package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.ChiTietSanPham;
import com.se.entity.KichThuoc;
import com.se.entity.SanPham;
import com.se.service.ChiTietSanPhamService;
import com.se.service.KichThuocService;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;

@Controller
public class ProductController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private KichThuocService kichThuocService;

	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;

	@GetMapping("/san-pham/chi-tiet-san-pham")
	public String showProductDetail(@RequestParam("maSanPham") String maSanPham, Model model) {
		// if(tenKichThuoc.equals(null)) {
		// tenKichThuoc = null;
		// }
		//
		// if(soLuongTon.equals(null)) {
		// soLuongTon = null;
		// }
		SanPham sanPham = sanPhamService.getById(maSanPham);
		model.addAttribute("sanPham", sanPham);
		List<String> listKichThuoc = kichThuocService.getDsKichThuocTheoMaSanPham(sanPham.getMaSanPham());

		model.addAttribute("dsKichThuoc", listKichThuoc);
		// model.addAttribute("tenKichThuoc",tenKichThuoc);
		// model.addAttribute("soLuongTon",soLuongTon);

		List<SanPham> list = sanPhamService.getByFilter("", "", "", 50000, 100000, 1, 9);
		model.addAttribute("listSanPham", list);

		List<String[]> listPreadcrumb = new ArrayList<String[]>();
		listPreadcrumb.add(new String[] { "Home", "" });
		listPreadcrumb.add(new String[] { "Sản phẩm", "/san-pham" });
		listPreadcrumb.add(new String[] { "Chi tiết sản phẩm", "" });
		System.err.println(model.getAttribute("chiTietSanPham"));

		model.addAttribute("listPreadcrumb", listPreadcrumb);

		return "productDetail";
	}

	// @GetMapping("/san-pham/so-luong-ton")
	// public void showSoLuongTon(Model model, @RequestParam("maSanPham") String
	// maSanPham, @RequestParam("kichThuoc") String kichThuoc) {
	// KichThuoc kichThuoc2 =
	// kichThuocService.getKichThuocTheoTenKichThuoc(kichThuoc);
	// ChiTietSanPham chiTietSanPham =
	// chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc(maSanPham,
	// kichThuoc2.getMaKichThuoc());
	// model.addAttribute("chiTietSanPham",chiTietSanPham);
	// }

	@RequestMapping(value = "/san-pham/so-luong-ton", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String addNew(HttpServletRequest request) {
		String maSanPham = request.getParameter("maSanPham");
		String tenKichThuoc = request.getParameter("tenKichThuoc");
		// JSONObject obj = new JSONObject();

		ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamByMaSanPhamMaKichThuoc(maSanPham,
				kichThuocService.getKichThuocTheoTenKichThuoc(tenKichThuoc).getMaKichThuoc());
		// ObjectMapper mapper = new ObjectMapper();
		// String ajaxResponse = "";
		// try {
		// ajaxResponse = mapper.writeValueAsString(chiTietSanPham);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// obj.put("soLuong", chiTietSanPham.getSoLuongTon());
		// System.out.println(maSanPham+"--"+tenKichThuoc);
		// System.err.println(chiTietSanPham);
		//
		//
		return chiTietSanPham.getSoLuongTon() + "";
	}
	
	@RequestMapping(value = "/san-pham/so-luong-ton/tang", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String quantityPluss(HttpServletRequest request) {
		int quantityTotal = Integer.parseInt(request.getParameter("quantityTotal"));
		int quantityCurrent = Integer.parseInt(request.getParameter("quantityCurrent"));
		
		
		// JSONObject obj = new JSONObject();

		if(quantityCurrent<quantityTotal) {
			quantityCurrent ++;
		}
		return String.valueOf(quantityCurrent);
	}
	
	@RequestMapping(value = "/san-pham/so-luong-ton/giam", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String quantityPrivate(HttpServletRequest request) {
		int quantityTotal = Integer.parseInt(request.getParameter("quantityTotal"));
		int quantityCurrent = Integer.parseInt(request.getParameter("quantityCurrent"));
		
		
		// JSONObject obj = new JSONObject();

		if(quantityCurrent>0) {
			quantityCurrent --;
		}
		System.out.println(quantityCurrent);
		return String.valueOf(quantityCurrent);
	}
}
