package com.se.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.HinhAnhSanPham;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.entity.SanPhamTrongGioHang;
import com.se.service.HinhAnhService;
import com.se.service.NguoiDungService;
import com.se.util.FileCustom;
import com.se.util.User;

@Controller
@PropertySource({ "classpath:value-mssql.properties" })
public class HinhAnhController {
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private HinhAnhService hinhAnhService;

	@Autowired
	private Environment env;

	@ResponseBody
	@RequestMapping(value = "/quan-ly/hinh-anh/them-hinh-anh", method = RequestMethod.POST, produces = "application/vnd.baeldung.api.v1+json")
	public String themHinhAnh(HttpServletRequest request, HttpSession httpSession) {
		String pathBuild = httpSession.getServletContext().getRealPath("/") + File.separator + "resources"
				+ File.separator + "images" + File.separator;
		String pathproject = env.getProperty("path.resources") + File.separator + "images" + File.separator + "test"
				+ File.separator;
		boolean status = true;
		try {
			String maSanPham = request.getParameter("maSanPham");
			String image = request.getParameter("image");
			// list file
			UUID name = UUID.randomUUID();
			String extension = image.split(",")[0].split(";")[0].split("/")[1]; // png || jpeg.....
			String base64 = image.split(",")[1];
			FileCustom.saveFileBase64(pathBuild, name + "", extension, base64);
			FileCustom.saveFileBase64(pathproject, name + "", extension, base64);
			hinhAnhService.themHinhAnhSanPham(new HinhAnhSanPham("", new SanPham(maSanPham), name + "."+extension));
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return "{\"status\": \"" + status + "\"}";
	}
	@ResponseBody
	@RequestMapping(value = "/quan-ly/hinh-anh/xoa-hinh-anh", method = RequestMethod.DELETE, produces = "application/vnd.baeldung.api.v1+json")
	public String xoaHinhAnh(HttpServletRequest request) {
		String tenHinhAnh = request.getParameter("tenHinhAnh");
		System.out.println(tenHinhAnh);
		boolean status  = hinhAnhService.xoaHinhAnhSanPham(tenHinhAnh);
		return "{\"status\": \"" + status + "\"}";
	}

}
