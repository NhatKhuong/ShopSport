package com.se.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.NguoiDung;
import com.se.entity.NhanHieu;
import com.se.entity.PhanQuyen;
import com.se.service.DiaChiService;
import com.se.service.NguoiDungService;
import com.se.service.PhanQuyenService;
import com.se.service.SanPhamService;

@Controller
public class NguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private DiaChiService diaChiService;
	@Autowired
	private PhanQuyenService phanQuyenService;

	@RequestMapping(value = "/dang-ky-user", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themUser(HttpServletRequest req) {
		String maNDCuoi = nguoiDungService.getMaNguoiDungCuoiCung().substring(4);
		// Chuyển String
		int soMaNDCuoi = Integer.parseInt(maNDCuoi);
		// + mã lên để thành mã mới
		soMaNDCuoi++;
		// Định dạng lại mã mới
		String maSP = String.format("NDAA%05d", soMaNDCuoi);
		String tenNguoiDung = req.getParameter("tenNguoiDung");
		String emailNguoiDung = req.getParameter("emailNguoiDung");
		String passWord = req.getParameter("passWord");
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setMaNguoiDung(maSP);
		nguoiDung.setHoTen(tenNguoiDung);
		nguoiDung.setEmail(emailNguoiDung);
		nguoiDung.setDiaChi(diaChiService.getDiaChi("Thị trấn Cờ Đỏ","Huyện Cờ Đỏ","Thành phố Cần Thơ"));
		nguoiDung.setMatKhau("{noop}"+passWord);
		nguoiDung.setTrangThai(true);
		nguoiDungService.save(nguoiDung);
		PhanQuyen phanQuyen = new PhanQuyen("ROLE_KHACH", nguoiDung);  
		phanQuyenService.save(phanQuyen);
		return "Add User Success";
	}

	@RequestMapping(value = "/is-login", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String checkLogin() {
		boolean status = false;
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String email;
			
			if (principal instanceof UserDetails) {
				email = ((UserDetails) principal).getUsername();
			} else {
				email = principal.toString();
			}
			System.out.println(email);
			if (!email.equalsIgnoreCase("anonymousUser"))
				status = true;
		} catch (Exception e) {
			// TODO: handle exception
			status = false;
		}

		return "{\"status\": \"" + status + "\"}";
	}

}
