package com.se.controller;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.se.entity.DanhGia;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.service.DanhGiaDaoService;
import com.se.service.NguoiDungService;
import com.se.util.User;

@Controller
public class DanhGiaController {
	@Autowired
	NguoiDungService nguoiDungService ;
	
	@Autowired
	DanhGiaDaoService danhGiaService;

	
	
	@RequestMapping(value = "/danh-gia/them-danh-gia", method = RequestMethod.POST)
	public @ResponseBody String themDanhGiaCoAnh(@RequestPart("file") MultipartFile multipartFile, HttpSession httpSession,
			HttpServletRequest request) {
		boolean status = true;
		try {
			String review = request.getParameter("review");
			String rating = request.getParameter("rating");
			String maSanPham = request.getParameter("productId");
			String fileName ="";
		
			SanPham sanPham = new SanPham(maSanPham);
			NguoiDung nguoiDung = nguoiDungService.getByEmail(User.getEmailNguoiDung());

//			File.separator if linux = \ if window = /
			String filePath = httpSession.getServletContext().getRealPath("/") + File.separator + "resources"
					+ File.separator + "images" + File.separator + "reviews" + File.separator;
		
//		 check file not null 
			if(!multipartFile.getOriginalFilename().equals("")) {
				UUID name = UUID.randomUUID();  // auto random name file 
				String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename()); // .png
				 fileName =  name + "." + extension;
				File file = new File(filePath,fileName);
				multipartFile.transferTo(file); 
			}
			// save image
			DanhGia danhGia = new DanhGia(sanPham, nguoiDung, Integer.parseInt(rating), review,fileName , new Date());
			if(!danhGiaService.themDanhGia(danhGia)){
				status = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return "{\"status\": \"" + status + "\"}";
	}
}
