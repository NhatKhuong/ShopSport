package com.se.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.DiaChi;
import com.se.service.DiaChiService;
import com.se.service.KichThuocService;

@Controller
public class DiaChiController {

	@Autowired
	private DiaChiService diaChiService;

	@Autowired
	private KichThuocService kichThuoc;

	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-dia-chi", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<DiaChi> danhSachDiaChiAjax() {
		return diaChiService.getDanhSachDiaChi();
	}

	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-tinh-thanh-pho", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<String> danhSachTinhThanhPhoAjax() {
	
		return diaChiService.getDanhSachTinhThanhPho();
	}

	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-quan-huyen-theo-thanh-pho", method = RequestMethod.GET)
	public List<String> danhSachQuanHuyenTheoTinh(HttpServletRequest request) {
		String thanhPho = request.getParameter("tinhThanhPho");
		return diaChiService.getDanhSachQuanHuyenTheoTinh(thanhPho);
	}

	@ResponseBody
	@RequestMapping(value = "/dia-chi/danh-sach-phuong-xa-theo-quan-huyen", method = RequestMethod.GET)
	public List<String> danhSachPhuongXaTheoQuanHuyen(HttpServletRequest request) {
		String thanhPho = request.getParameter("tinhThanhPho");
		String quanHuyen = request.getParameter("quanHuyen");
		return diaChiService.getDanhSachPhuongXaTheoQuanHuyenVaTinh(quanHuyen, thanhPho);
	}
}
