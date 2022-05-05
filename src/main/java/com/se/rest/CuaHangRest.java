package com.se.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.LoaiSanPham;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.SanPhamService;

@Controller
public class CuaHangRest {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@ResponseBody
	@RequestMapping(value = "/cua-hang/soTrang", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public int getNumPage(HttpServletRequest request) {
		List<String> listLoaiSanPham = Arrays.asList(request.getParameter("listLoaiSanPham").split(","));
		List<String> listMonTheThao = Arrays.asList(request.getParameter("listMonTheThao").split(","));
		List<String> listNhanHieu = Arrays.asList(request.getParameter("listNhanHieu").split(","));
		int limit = Integer.parseInt(request.getParameter("limit"));
		double price_to = Double.parseDouble(request.getParameter("price_to"));
		double price_from = Double.parseDouble(request.getParameter("price_from"));
		
		String strLoaiSanPham = "";
		if(listLoaiSanPham == null) {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%%'";	
		} else if(listLoaiSanPham.size() == 1){
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";	
		} else {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";			
			for(int i = 1; i<listLoaiSanPham.size();i++) {
				strLoaiSanPham += " or " + "LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(i)+"%'";
			}
		}
		
		
		String strMonTheThao = "";
		if(listMonTheThao == null) {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%%'";	
		} else if(listMonTheThao.size() == 1){
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";
		} else {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";			
			for(int i = 1; i<listMonTheThao.size();i++) {
				strMonTheThao += " or " + "MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(i)+"%'";
			}
		}
	
		String strNhanHieu = "";
		if(listNhanHieu == null) {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%%'";	
		} else if(listNhanHieu.size() == 1){
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";
		} else {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";			
			for(int i = 1; i<listNhanHieu.size();i++) {
				strNhanHieu += " or " + "NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(i)+"%'";
			}
		}
		
		int numResult = sanPhamService.getNumResult(strLoaiSanPham, strMonTheThao, strNhanHieu, price_to, price_from);
		int totalPage = numResult % limit == 0 ? numResult/limit : (numResult/limit)+1; 
		System.out.println("totalPage:  "+totalPage);
		return totalPage;
	}
	
	@ResponseBody
	@RequestMapping(value = "/cua-hang/loc", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<SanPham> filterProduct(HttpServletRequest request ) {
		List<String> listLoaiSanPham = Arrays.asList(request.getParameter("listLoaiSanPham").split(","));
		List<String> listMonTheThao = Arrays.asList(request.getParameter("listMonTheThao").split(","));
		List<String> listNhanHieu = Arrays.asList(request.getParameter("listNhanHieu").split(","));
	
		double price_to = Double.parseDouble(request.getParameter("price_to"));
		double price_from = Double.parseDouble(request.getParameter("price_from"));
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		System.out.println(listLoaiSanPham);
		System.out.println(listMonTheThao);
		System.out.println(listNhanHieu);
		System.out.println(price_to);
		System.out.println(price_from);
		System.out.println(pageIndex);
		System.out.println(limit);
	
		String strLoaiSanPham = "";
		if(listLoaiSanPham == null) {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%%'";	
		} else if(listLoaiSanPham.size() == 1){
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";	
		} else {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";			
			for(int i = 1; i<listLoaiSanPham.size();i++) {
				strLoaiSanPham += " or " + "LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(i)+"%'";
			}
		}
		
		
		String strMonTheThao = "";
		if(listMonTheThao == null) {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%%'";	
		} else if(listMonTheThao.size() == 1){
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";
		} else {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";			
			for(int i = 1; i<listMonTheThao.size();i++) {
				strMonTheThao += " or " + "MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(i)+"%'";
			}
		}
	
		String strNhanHieu = "";
		if(listNhanHieu == null) {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%%'";	
		} else if(listNhanHieu.size() == 1){
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";
		} else {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";			
			for(int i = 1; i<listNhanHieu.size();i++) {
				strNhanHieu += " or " + "NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(i)+"%'";
			}
		}
		
		List<SanPham> listResult = sanPhamService.getSanPhamFilter(strLoaiSanPham, strMonTheThao, strNhanHieu, price_to, price_from, pageIndex, limit);
		
		
		return listResult;
			
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cua-hang/max-price", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String getMaxPrice(HttpServletRequest request ) {
		System.out.println("====vào");
		List<String> listLoaiSanPham = Arrays.asList(request.getParameter("listLoaiSanPham").split(","));
		List<String> listMonTheThao = Arrays.asList(request.getParameter("listMonTheThao").split(","));
		List<String> listNhanHieu = Arrays.asList(request.getParameter("listNhanHieu").split(","));
		
		String strLoaiSanPham = "";
		if(listLoaiSanPham == null) {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%%'";	
		} else if(listLoaiSanPham.size() == 1){
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";	
		} else {
			strLoaiSanPham = " LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(0)+"%'";			
			for(int i = 1; i<listLoaiSanPham.size();i++) {
				strLoaiSanPham += " or " + "LoaiSanPham.tenLoaiSanPham like N'%"+listLoaiSanPham.get(i)+"%'";
			}
		}
		
		
		String strMonTheThao = "";
		if(listMonTheThao == null) {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%%'";	
		} else if(listMonTheThao.size() == 1){
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";
		} else {
			strMonTheThao = " MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(0)+"%'";			
			for(int i = 1; i<listMonTheThao.size();i++) {
				strMonTheThao += " or " + "MonTheThao.tenMonTheThao like N'%"+listMonTheThao.get(i)+"%'";
			}
		}
	
		String strNhanHieu = "";
		if(listNhanHieu == null) {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%%'";	
		} else if(listNhanHieu.size() == 1){
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";
		} else {
			strNhanHieu = " NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(0)+"%'";			
			for(int i = 1; i<listNhanHieu.size();i++) {
				strNhanHieu += " or " + "NhanHieu.tenNhanHieu like N'%"+listNhanHieu.get(i)+"%'";
			}
		}
		
		double maxPrice = sanPhamService.getMaxPrice(strLoaiSanPham, strMonTheThao, strNhanHieu);
		System.out.println("maxPrice rest: "+maxPrice);
		return "{\"maxPrice\": \"" + maxPrice + "\"}";
		
		
	}
	

}
