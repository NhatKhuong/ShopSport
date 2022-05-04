package com.se.admin.rest;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.DonHang;
import com.se.entity.TrangThaiDonHang;
import com.se.service.DonHangService;

@Controller
public class HoaDonRest {
	
	@Autowired
	private DonHangService donHangService;
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/hoa-don/load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<DonHang> getDanhSachDonHang(HttpServletRequest request) {
		String maTrangThai = request.getParameter("maTrangThai");
		String maKhachHang = request.getParameter("maKhachHang");
		String tenKhachHang = request.getParameter("tenKhachHang");
		System.out.println("============"+maTrangThai);
		List<DonHang> list = donHangService.getDanhSachDonHangTheoTrangThai(maTrangThai, maKhachHang, tenKhachHang);
		System.out.println(list);
		return list;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/hoa-don/tong-tien", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public double getTongTien(HttpServletRequest request) {
		
		String maHoaDon = request.getParameter("maHoaDon");
		return donHangService.tinhTongTien(maHoaDon);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/hoa-don/chuyen-trang-thai", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String chuyenTrangThai(HttpServletRequest request) {
		
		String maHoaDon = request.getParameter("maHoaDon");
		DonHang donHang = donHangService.getDonHangById(maHoaDon);
		String trangThaiCu = donHang.getTrangThaiDonHang().getMaTrangThaiDonHang();
		
		if(donHang.getTrangThaiDonHang().getMaTrangThaiDonHang().equals("TTDH00001")) {
			donHang.setTrangThaiDonHang(new TrangThaiDonHang("TTDH00002"));
		} else if(donHang.getTrangThaiDonHang().getMaTrangThaiDonHang().equals("TTDH00002")) {
			donHang.setTrangThaiDonHang(new TrangThaiDonHang("TTDH00003"));
		} else if(donHang.getTrangThaiDonHang().getMaTrangThaiDonHang().equals("TTDH00003")) {
			donHang.setTrangThaiDonHang(new TrangThaiDonHang("TTDH00004"));
		} else if(donHang.getTrangThaiDonHang().getMaTrangThaiDonHang().equals("TTDH00005")) {
			donHang.setTrangThaiDonHang(new TrangThaiDonHang("TTDH00003"));
		}
		donHangService.update(donHang);
		return "{\"trangThaiCu\": \"" + trangThaiCu + "\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/hoa-don/huy-trang-thai", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String huyTrangThai(HttpServletRequest request) {		
		String maHoaDon = request.getParameter("maHoaDon");
		DonHang donHang = donHangService.getDonHangById(maHoaDon);
		String trangThaiCu = donHang.getTrangThaiDonHang().getMaTrangThaiDonHang();
		
		donHang.setTrangThaiDonHang(new TrangThaiDonHang("TTDH00005"));
		donHangService.update(donHang);
//		return {"trangThaiCu":trangThaiCu};
		return "{\"trangThaiCu\": \"" + trangThaiCu + "\"}";
		
		
	}
	

}
