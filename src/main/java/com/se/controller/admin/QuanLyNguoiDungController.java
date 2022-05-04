package com.se.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.se.entity.NguoiDung;
import com.se.service.NguoiDungService;

@Controller
public class QuanLyNguoiDungController {
	
//	@RequestMapping("/quan-ly/quan-ly-nguoi-dung")
//	public String showQuanLyNguoiDung() {
//		return "admin/quanLyNguoiDung";
//	}
	
	@Autowired
	private NguoiDungService nguoiDungService;

	@RequestMapping("/quan-ly/quan-ly-nguoi-dung")
	public String quanLyNguoiDung(Model model) {
		List<NguoiDung> list = nguoiDungService.getByFilter("", "");
		model.addAttribute("listNguoiDung", list);
		return "admin/quanLyNguoiDung";
	}

	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-nguoi-dung-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<NguoiDung> showQuanLyNguoiDung(HttpServletRequest request) {
		System.out.println("Vào//////////////////////$$$$");

		// get persons from the service

		List<NguoiDung> list = nguoiDungService.getByFilter("","");

		// List<NguoiDung> list=nguoiDungService.getAll();

		System.out.println(list);

		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-nguoi-dung-xoa", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String xoaSanPhamTheoMa(HttpServletRequest request) {
		String maNguoiDung = request.getParameter("maNguoiDung");
		nguoiDungService.deletePerson(maNguoiDung);
		return "Xóa thành công";
	}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-nguoi-dung-loc", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<NguoiDung> locSanPhamTheoTen(HttpServletRequest request) {
		String hoTen = request.getParameter(("hoTen"));
		int trangThai = Integer.parseInt(request.getParameter("trangThai"));
		/*
		 * int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
		 */
		List<NguoiDung> listSanPham = nguoiDungService.getByName_Status(hoTen, trangThai);
		return listSanPham;
	}
	

	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-nguoi-dung-cap-nhat", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String capNhatSanPham(HttpServletRequest request) {
		String maNguoiDung = request.getParameter("maNguoiDung");
		String hoTen = request.getParameter("hoTen");
		String diaChiChiTiet=request.getParameter("diaChiChiTiet");
		int gioiTinh=Integer.parseInt(request.getParameter("gioiTinh"));
		int trangThai = Integer.parseInt(request.getParameter("trangThai"));
		String matKhau=request.getParameter("matKhau");
		return  nguoiDungService.capNhatNguoiDung(maNguoiDung, hoTen, diaChiChiTiet, gioiTinh, trangThai, matKhau)?"Cập nhật thành công":"Cập nhật thất bại";
	}

	
	

}
