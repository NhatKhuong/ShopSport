package com.se.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NhanHieu;
import com.se.entity.SanPham;
import com.se.service.ChiTietSanPhamService;
import com.se.service.LoaiSanPhamService;
import com.se.service.MonTheThaoService;
import com.se.service.NhanHieuService;
import com.se.service.SanPhamService;

@Controller
public class QuanLySanPhamController {
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private MonTheThaoService monTheThaoService;
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	@Autowired
	private NhanHieuService nhanHieuService;
	@Autowired
	private ChiTietSanPhamService chiTietSanPhamService;

	@RequestMapping("/quan-ly/quan-ly-san-pham")
	public String quanLyDonHang(Model model) {
		/*List<?> list = sanPhamService.getDanhSachSanPham_SoLuong();
		List<String> listMaSanPham = new ArrayList<String>();
		for (Object ob : list) {
			Object[] listO = (Object[]) ob;
			// từng thuộc tính vô như
			String stt = (String) listO[0];
			String stt1 = (String) listO[1];
			int stt2 = Integer.parseInt(listO[2].toString());
			double stt3 = Double.parseDouble(listO[3].toString());
			String stt4 = (String) listO[4];
			boolean stt5 = (boolean) listO[5];
			String stt6 = " ";
			if (stt5)
				stt6 += "Đang kinh doanh";
			else
				stt6 += "Ngừng kinh doanh";
//			System.out.println(stt + "  " + stt1 + "  " + stt2 + "  " + stt3 + "  " + stt4 + "  " + stt6);
			
			listMaSanPham.add(stt);
		}
		
		model.addAttribute("listMaSanPham",listMaSanPham);
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");*/

		return "admin/quanLySanPham";
	}

	@RequestMapping("/quan-ly/them-san-pham")
	public String themSanPham(Model model) {
		String maSPCuoi = sanPhamService.getMaSanPhamCuoiCung().substring(4);
		int soMaSPCuoi = Integer.parseInt(maSPCuoi);
		soMaSPCuoi++;
		String maSP = String.format("SPAA%05d", soMaSPCuoi);
		model.addAttribute("maSP", maSP);
		List<MonTheThao> listMTT = monTheThaoService.getAllMTT();
		List<String> listTenMonTT = new ArrayList<String>();
		for (MonTheThao a : listMTT) {
			listTenMonTT.add(a.getTenMonTheThao());
		}
		model.addAttribute("listTenMonTT", listTenMonTT);
		List<LoaiSanPham> listLoaiSP = loaiSanPhamService.getAllLoaiSanPham();
		List<String> listTenLoaiSP = new ArrayList<String>();
		for (LoaiSanPham a : listLoaiSP) {
			listTenLoaiSP.add(a.getTenLoaiSanPham());
		}
		model.addAttribute("listTenLoaiSP", listTenLoaiSP);
		List<NhanHieu> listNhanHieu = nhanHieuService.getAllNhanHieu();
		List<String> listTenNhanHieu = new ArrayList<String>();
		for (NhanHieu a : listNhanHieu) {
			listTenNhanHieu.add(a.getTenNhanHieu());
		}
		model.addAttribute("listTenNhanHieu", listTenNhanHieu);
		String maLoaiSPCuoi = loaiSanPhamService.getMaLoaiSanPhamCuoiCung().substring(3);
		int soMaLoaiSPCuoi = Integer.parseInt(maLoaiSPCuoi);
		soMaLoaiSPCuoi++;
		String maLoaiSP = String.format("LSP%05d", soMaLoaiSPCuoi);
		model.addAttribute("maLoaiSP", maLoaiSP);
		String maNhanHieuCuoi = nhanHieuService.getMaCuoiNhanHieu().substring(2);
		int soMaNhanHieuCuoi = Integer.parseInt(maNhanHieuCuoi);
		soMaNhanHieuCuoi++;
		String maNhanHieu = String.format("NH%05d", soMaNhanHieuCuoi);
		model.addAttribute("maNhanHieu", maNhanHieu);
		String maMTTCuoi = monTheThaoService.getMaMTTCuoi().substring(3);
		int soMaMTTCuoi = Integer.parseInt(maMTTCuoi);
		soMaMTTCuoi++;
		String maMTT = String.format("MTT%05d", soMaMTTCuoi);
		model.addAttribute("maMTT", maMTT);

		return "admin/themSanPham";
	}

	@RequestMapping(value = "/quan-ly/them-mon-the-thao", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themMonTheThao(HttpServletRequest req) {
		String maMonTheThao = req.getParameter("maMonTheThao");
		String tenMonTheThao = req.getParameter("tenMonTheThao");
		List<MonTheThao> listMonTheThao = monTheThaoService.getAllMTT();
		MonTheThao monTheThao = new MonTheThao(maMonTheThao, tenMonTheThao);
		String tenMonTheThaotemp = "";
		for (MonTheThao a : listMonTheThao) {
			if (a.getTenMonTheThao().toString().trim().equalsIgnoreCase(tenMonTheThao)) {
				tenMonTheThaotemp = tenMonTheThao;
			}
		}
		if (tenMonTheThaotemp.equalsIgnoreCase("") && !tenMonTheThao.equalsIgnoreCase("")) {
			monTheThaoService.saveMTT(monTheThao);
			System.out.println("oke");
		} else {
			System.out.println("Tr�ng");
		}
		return "add success";
	}

	@RequestMapping(value = "/quan-ly/them-nhan-hieu", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themNhanHieu(HttpServletRequest req) {
		String maNhanHieu = req.getParameter("maNhanHieu");
		String tenNhanHieu = req.getParameter("tenNhanHieu");
		List<NhanHieu> listNhanHieu = nhanHieuService.getAllNhanHieu();
		NhanHieu nhanHieu = new NhanHieu(maNhanHieu, tenNhanHieu);
		String tenNhanHieutemp = "";
		for (NhanHieu a : listNhanHieu) {
			if (a.getTenNhanHieu().toString().trim().equalsIgnoreCase(tenNhanHieu)) {
				tenNhanHieutemp = tenNhanHieu;
			}
		}
		if (tenNhanHieutemp.equalsIgnoreCase("") && !tenNhanHieu.equalsIgnoreCase("")) {
			nhanHieuService.saveNhanHieu(nhanHieu);
			System.out.println("oke");
		} else {
			System.out.println("Tr�ng");
		}
		return "add success";
	}

	@RequestMapping(value = "/quan-ly/them-loai-san-pham", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themLoaiSanPham(HttpServletRequest req) {
		String maLoaiSanPham = req.getParameter("maLoaiSanPham");
		String tenLoaiSanPham = req.getParameter("tenLoaiSanPham");
		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.getAllLoaiSanPham();
		LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
		String tenLoaiSanPhamtemp = "";
		for (LoaiSanPham a : listLoaiSanPham) {
			if (a.getTenLoaiSanPham().toString().trim().equalsIgnoreCase(tenLoaiSanPham)) {
				tenLoaiSanPhamtemp = tenLoaiSanPham;
			}
		}
		if (tenLoaiSanPhamtemp.equalsIgnoreCase("") && !tenLoaiSanPham.equalsIgnoreCase("")) {
			loaiSanPhamService.saveLoaiSanPham(loaiSanPham);
			System.out.println("oke");
		} else {
			System.out.println("Tr�ng");
		}
		return "add success";
	}

	@RequestMapping(value = "/quan-ly/them-san-pham-moi", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themSanPhamMoi(HttpServletRequest req) {
		String maSanPham = req.getParameter("maSanPham");
		String tenMaSanPham = req.getParameter("tenMaSanPham");
		int soLuong = Integer.parseInt(req.getParameter("soLuong"));
		String tenmonTheThao = req.getParameter("monTheThao");
		String tenloaiSanPham = req.getParameter("loaiSanPham");
		String tennhanHieu = req.getParameter("nhanHieu");
		double giaTien = Double.parseDouble(req.getParameter("giaTien"));
		float chietKhau = Float.parseFloat(req.getParameter("chietKhau"));
		String mota = req.getParameter("mota");
		String img = req.getParameter("img");
		System.out.println(maSanPham);
		System.out.println(tenMaSanPham);
		System.out.println(soLuong);
		System.out.println(tenmonTheThao);
		System.out.println(tenloaiSanPham);
		System.out.println(tennhanHieu);
		System.out.println(giaTien);
		System.out.println(chietKhau);
		System.out.println(img);
		System.out.println(mota);
		MonTheThao monTheThao = monTheThaoService.timMonTheThaoBangTen(tenmonTheThao);
		LoaiSanPham loaiSanPham = loaiSanPhamService.timLoaiSanPhambangTen(tenloaiSanPham);
		System.out.println(monTheThao.toString());
		System.out.println(loaiSanPham.toString());
		NhanHieu nhanHieu = nhanHieuService.timNhanHieuBangTen(tennhanHieu);
		System.out.println(nhanHieu.toString());

//		List<LoaiSanPham> listLoaiSanPham = loaiSanPhamService.getAllLoaiSanPham(); 
//		LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
//		String tenLoaiSanPhamtemp = "";
//		for(LoaiSanPham a : listLoaiSanPham) {
//			if(a.getTenLoaiSanPham().toString().trim().equalsIgnoreCase(tenLoaiSanPham)) {
//				tenLoaiSanPhamtemp = tenLoaiSanPham;
//			}
//		}
//		if(tenLoaiSanPhamtemp.equalsIgnoreCase("") && !tenLoaiSanPham.equalsIgnoreCase("")) {
//			loaiSanPhamService.saveLoaiSanPham(loaiSanPham);
//			System.out.println("oke");
//		}
//		else {
//			System.out.println("Tr�ng");
//		}
		return "add success";
	}

	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-san-pham-loc", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<SanPham> locSanPhamTheoTen(HttpServletRequest request) {
		int trangThai = Integer.parseInt(request.getParameter("trangThai"));
		String loaiSanPham = request.getParameter("loaiSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		double giaTien = Double.parseDouble(request.getParameter("giaTien"));
		List<SanPham> listSanPham = sanPhamService.getByName_Status(tenSanPham, trangThai, giaTien, loaiSanPham);
		return listSanPham;
	}
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-san-pham-cap-nhat", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String capNhatSanPham(HttpServletRequest request) {
		String maSanPham = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		int trangThai = Integer.parseInt(request.getParameter("trangThai"));
		double giaTien = Double.parseDouble(request.getParameter("giaTien").split("đ")[0]);
		return  sanPhamService.capNhatSanPham(maSanPham, tenSanPham, giaTien, trangThai)?"Cập nhật thành công":"Cập nhật thất bại";
	}
	

	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-san-pham-doi-trang-thai", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public String xoaSanPhamTheoMa(HttpServletRequest request) {
		String maSanPham = request.getParameter("maSanPham");
		sanPhamService.delete(maSanPham);
		return "Xóa thành công";
	}

	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-san-pham-load-lsp", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public List<LoaiSanPham> loadLoaiSanPham(HttpServletRequest request) {
		return loaiSanPhamService.getDanhSachTenLoaiSanPham();
	}

	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@ResponseBody
	@RequestMapping(value = "/quan-ly/quan-ly-san-pham-load-so-luong", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public int loadTongSoLuong(HttpServletRequest request) {
		return sanPhamService.getSoLuongSanPhamTheoMa(request.getParameter("maSanPham"));
	}
}
