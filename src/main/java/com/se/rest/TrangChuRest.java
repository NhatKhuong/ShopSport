package com.se.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.SanPham;
import com.se.service.SanPhamService;

@Controller
public class TrangChuRest {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	
	@ResponseBody
	@RequestMapping(value = "/trang-chu/loc", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<SanPham> filterByButton(HttpServletRequest request){
		List<SanPham> listResult = new ArrayList<SanPham>();
		String condition = request.getParameter("condition");
		System.out.println("========================================="+condition);
		if(condition.equalsIgnoreCase("QUẦN ÁO")) {
			listResult = sanPhamService.getSanPhamByLoaiSanPham("Quần áo");		
		} else if(condition.equalsIgnoreCase("DỤNG CỤ & THIẾT BỊ")) {
			listResult = sanPhamService.getSanPhamByLoaiSanPham("Dụng cụ");
		} else if(condition.equalsIgnoreCase("GIẦY THỂ THAO")) {
			listResult = sanPhamService.getSanPhamByLoaiSanPham("Giày");
		} else {
			listResult = sanPhamService.getAllTop20();
		}
		return listResult;	
	}
	
	

	@ResponseBody
	@RequestMapping(value = "/header/tim-kiem", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<SanPham> loadDataSearch(HttpServletRequest request){
		
		String condition = request.getParameter("contition");
		List<SanPham> list = new ArrayList<SanPham>();
		if(condition.equals("")) {
			list = sanPhamService.getSanPhamBanChay();
		}else {
			list = sanPhamService.getDanhSachSanPhamTimKiem(condition);			
		}
		return list;	
	}
}
