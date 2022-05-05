package com.se.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.NhanHieu;
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;

@Controller
public class NguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private SanPhamService sanPhamService;

	@RequestMapping(value = "/dang-ky-user", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themUser(HttpServletRequest req) {
		String maSPCuoi = sanPhamService.getMaSanPhamCuoiCung().substring(4);
		// Chuyển String
		int soMaSPCuoi = Integer.parseInt(maSPCuoi);
		// + mã lên để thành mã mới
		soMaSPCuoi++;
		// Định dạng lại mã mới
		String maSP = String.format("SPAA%05d", soMaSPCuoi);

		nguoiDungService.save(null);
		return "Add User Success";
	}

}
