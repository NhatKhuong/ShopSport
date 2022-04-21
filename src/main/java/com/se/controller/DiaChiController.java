package com.se.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.DiaChi;
import com.se.service.impl.DiaChiServiceImpl;

@Controller
public class DiaChiController {
	@Autowired
	private DiaChiServiceImpl diaChiServiceImpl; 
	 
	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-dia-chi", method = RequestMethod.GET )
	public  List<DiaChi>   danhSachDiaChiAjax() {
		return   diaChiServiceImpl.getDanhSachDiaChi();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-tinh-thanh-pho", method = RequestMethod.GET )
	public  List<String>   danhSachTinhThanhPhoAjax() {
		return   diaChiServiceImpl.getDanhSachTinhThanhPho();
	}
	 @ResponseBody
	@RequestMapping(value =  "/dia-chi/danh-sach-quan-huyen-theo-thanh-pho", method = RequestMethod.GET)
	public List<String> danhSachQuanHuyenTheoTinh(HttpServletRequest request) {
		String thanhPho = request.getParameter("tinhThanhPho");
		return diaChiServiceImpl.getDanhSachQuanHuyenTheoTinh(thanhPho);
	}
	 @ResponseBody
	@RequestMapping(value =  "/dia-chi/danh-sach-phuong-xa-theo-quan-huyen", method = RequestMethod.GET)
	public  List<String> danhSachPhuongXaTheoQuanHuyen(HttpServletRequest request) {
		String thanhPho = request.getParameter("thanhPho");
		String quanHuyen = request.getParameter("quanHuyen");
		return diaChiServiceImpl.getDanhSachPhuongXaTheoQuanHuyenVaTinh(quanHuyen, thanhPho);
	}
}

