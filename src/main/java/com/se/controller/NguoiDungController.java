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
import com.se.util.EncryptUtils;
import com.se.util.Mail;

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

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contact(HttpServletRequest request) {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		title =  "Contact support SHOPSHORT: " + title;
		String body =  "Contact from Email: "+email+ " Name: "+name+" with content: <br/> <p> "+content+" </p> ";
		try {
			Mail.sendEmail("nhatkhuong2001@gmail.com", title, body);
		} catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/contact";
	}

}
