package com.se.controller;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.se.entity.DanhGia;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.service.DanhGiaDaoService;
import com.se.service.NguoiDungService;
import com.se.util.User;

@Controller
@PropertySource({ "classpath:value-mssql.properties" })
public class DanhGiaController {
	@Autowired
	NguoiDungService nguoiDungService;

	@Autowired
	private Environment env;

	@Autowired
	DanhGiaDaoService danhGiaService;

	@RequestMapping(value = "/danh-gia/them-danh-gia", method = RequestMethod.POST)
	public @ResponseBody String themDanhGiaCoAnh(@RequestPart("file") MultipartFile multipartFile,
			HttpSession httpSession, HttpServletRequest request) {
		boolean status = true;
		try {
			String review = request.getParameter("review");
			String rating = request.getParameter("rating");
			String maSanPham = request.getParameter("productId");
			String fileName = null;

			SanPham sanPham = new SanPham(maSanPham);
			NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
			DanhGia danhGia = null;
//			File.separator if linux = \ if window = /
			String filePath = httpSession.getServletContext().getRealPath("/") + File.separator + "resources"
					+ File.separator + "images" + File.separator + "reviews" + File.separator;

//		 check file not null 
			if (!multipartFile.getOriginalFilename().equals("")) {
				UUID name = UUID.randomUUID(); // auto random name file
				String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename()); // .png
				fileName = name + "." + extension;
				File file = new File(filePath, fileName);
				multipartFile.transferTo(file);
				// save in 2 locations: in this project and project build
				try {
					String pathResource = env.getProperty("path.resources");
					String pathLocal = pathResource +  File.separator +"images"+ File.separator+"reviews"+ File.separator;
					if(pathResource != null && !pathResource.equals("")) {
						File file2 = new File(pathLocal, fileName);
						 FileUtils.copyFile(file, file2);
						 file2.createNewFile();
				
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Path real in value-mssql.properties not foud");
					
				}
			

			}else {
				//  update but not update image 
				danhGia = danhGiaService.layDanhGiaTheoMaSanPhamVaMaNguoiDung(maSanPham, nguoiDung.getMaNguoiDung());
			}
			 
			if(danhGia == null) {
				danhGia = new DanhGia(sanPham, nguoiDung, Integer.parseInt(rating), review, fileName, new Date());
			}else {
				if(fileName != null) {
					danhGia.setHinhAnh(fileName);
//					delete image old
				}
				danhGia.setNoiDung(review);
				danhGia.setXepHang(Integer.parseInt(rating));
				danhGia.setThoiGian( new Date());
			}
			if (!danhGiaService.themDanhGia(danhGia)) {
				status = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return "{\"status\": \"" + status + "\"}";
	}

	@RequestMapping(value = "/danh-gia/danh-sach-danh-gia", method = RequestMethod.GET)
	public @ResponseBody String danhSachDanhGia(HttpServletRequest request) {
		int page = 0;
		int limit = 1;
		String maSanPham = request.getParameter("maSanPham");
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
			limit = Integer.parseInt(request.getParameter("limit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		List<DanhGia> danhSachDanhGia = danhGiaService.layDanhSachDanhGiaTheoMaSanPham(page, limit, maSanPham);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "{";
		try {
			json += "\"danhSachDanhGia\":" + ow.writeValueAsString(danhSachDanhGia);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json + "}";
	}
	@RequestMapping(value = "/danh-gia/danh-gia-theo-ma-san-pham", method = RequestMethod.GET)
	public @ResponseBody DanhGia danhSachDanhGiaTheoMaSanPhamVaMaNguoiDung(HttpServletRequest request) {
		String maSanPham = request.getParameter("maSanPham");
		NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());
		DanhGia danhGia = danhGiaService.layDanhGiaTheoMaSanPhamVaMaNguoiDung(maSanPham, nguoiDung.getMaNguoiDung());
		return danhGia;
	}

	@RequestMapping(value = "/danh-gia/tong-so-danh-gia", method = RequestMethod.GET)
	public @ResponseBody int tongSoDanhGia(HttpServletRequest request) {
		String maSanPham = request.getParameter("maSanPham");
		return danhGiaService.soLuongDanhGiaTheoMaSanPham(maSanPham);
	}
}
