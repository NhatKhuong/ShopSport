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
import com.se.service.NguoiDungService;
import com.se.service.SanPhamService;
import com.se.util.EncryptUtils;
import com.se.util.Mail;

@Controller
public class NguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private SanPhamService sanPhamService;

	@RequestMapping(value = "/dang-ky-user", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themUser(HttpServletRequest req) {
		String maSPCuoi = sanPhamService.getMaSanPhamCuoiCung().substring(4);
		// Chuyá»ƒn String
		int soMaSPCuoi = Integer.parseInt(maSPCuoi);
		// + mÃ£ lÃªn Ä‘á»ƒ thÃ nh mÃ£ má»›i
		soMaSPCuoi++;
		// Ä�á»‹nh dáº¡ng láº¡i mÃ£ má»›i
		String maSP = String.format("SPAA%05d", soMaSPCuoi);

		nguoiDungService.save(null);
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

	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public String quenMatKhau(HttpServletRequest request) {

		return "quenMatKhau";
	}

	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
	public String quenMatKhauPOST(HttpServletRequest request) {
		String error = null;
		String mailSend = request.getParameter("mail");
		try {

			if (mailSend == null) {
				throw new Exception("Bạn chưa nhập email");
			}
			
			String title = "Khôi phục mật khẩu";
			String body = "";
			String host = "http://" + request.getServerName() + ":"+request.getServerPort()+ request.getContextPath() +"/";
			NguoiDung nguoiDung = nguoiDungService.getByEmail(mailSend);
			if (nguoiDung == null)
				throw new Exception("Email không tồn tại");
			String maNguoiDungEncode = EncryptUtils.base64encode(nguoiDung.getMaNguoiDung());
			body = "Link khôi phục mật khẩu :   <a href='" + host + "dat-lai-mat-khau?token=" + maNguoiDungEncode
					+ "'>Link</a>";
			Mail.sendEmail(mailSend, title, body);
			request.setAttribute("message", "Vui lòng kiểm tra hộp thư email của bạn");
		} catch (Exception e) {
			error = e.getMessage();
		}
		request.setAttribute("error", error);
		request.setAttribute("mail", mailSend);
		return "quenMatKhau";
	}

	@RequestMapping(value = "/dat-lai-mat-khau", method = RequestMethod.GET)
	public String datLaiMatKhau(HttpServletRequest request) {
		String token = request.getParameter("token");
		String maNguoiDung = EncryptUtils.base64decode(token);
		if (maNguoiDung == null) {
			return "redirect:/";
		}
		return "datLaiMatKhau";
	}
	
	@RequestMapping(value = "/dat-lai-mat-khau", method = RequestMethod.POST)
	public String datLaiMatKhauPost(HttpServletRequest request) {
		String token = request.getParameter("token");
		String matKhau = request.getParameter("password");
		String error = null;
		String maNguoiDung = EncryptUtils.base64decode(token);
		if (maNguoiDung == null)
			error = "Cập nhật không thành công";
		else {
			boolean status = nguoiDungService.capNhatMatKhauNguoiDung(maNguoiDung, matKhau.trim());
		}
		return "redirect:/dang-nhap";
	}

}
