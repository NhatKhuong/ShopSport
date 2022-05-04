package com.se.controller.admin;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.entity.LoaiSanPham;
import com.se.entity.MonTheThao;
import com.se.entity.NhanHieu;
import com.se.service.LoaiSanPhamService;
import com.se.service.MonTheThaoService;
import com.se.service.NhanHieuService;
import com.se.service.SanPhamService;
import com.se.util.FileCustom;

@Controller
@PropertySource({ "classpath:value-mssql.properties" })
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
	private Environment env;

	@RequestMapping("/quan-ly/quan-ly-san-pham")
	public String quanLyDonHang() {
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
			System.out.println("Trùng");
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
			System.out.println("Trùng");
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
			System.out.println("Trùng");
		}
		return "add success";
	}

	@RequestMapping(value = "/quan-ly/them-san-pham-moi", method = RequestMethod.POST, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody String themSanPhamMoi(HttpServletRequest req, HttpSession httpSession) {
		String pathBuild = httpSession.getServletContext().getRealPath("/") + File.separator + "resources"
				+ File.separator + "images" + File.separator;
		String pathproject = env.getProperty("path.resources") + File.separator + "images" + File.separator + "test"
				+ File.separator;

		String maSanPham = req.getParameter("maSanPham");
		String tenMaSanPham = req.getParameter("tenMaSanPham");
		int soLuong = Integer.parseInt(req.getParameter("soLuong"));
		String tenmonTheThao = req.getParameter("monTheThao");
		String tenloaiSanPham = req.getParameter("loaiSanPham");
		String tennhanHieu = req.getParameter("nhanHieu");
		double giaTien = Double.parseDouble(req.getParameter("giaTien"));
		float chietKhau = Float.parseFloat(req.getParameter("chietKhau"));
		String danhSachHinhAnh64 = req.getParameter("danhSachHinhAnh");
		String mota = req.getParameter("mota");
		String img = req.getParameter("img");
		String[] images = danhSachHinhAnh64.split(",");

//		MonTheThao monTheThao = monTheThaoService.timMonTheThaoBangTen(tenmonTheThao);
//		LoaiSanPham loaiSanPham = loaiSanPhamService.timLoaiSanPhambangTen(tenloaiSanPham);
//		System.out.println(monTheThao.toString());
//		System.out.println(loaiSanPham.toString());
//		NhanHieu nhanHieu = nhanHieuService.timNhanHieuBangTen(tennhanHieu);
//		System.out.println(nhanHieu.toString());

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
//			System.out.println("Trùng");
//		}
//		File.separator if linux = \ if window = /

//		save images
		int length = images.length;
		int i = 0;
		String  base64, extension = "";
		UUID name = null;
		List<String> listFileName = new ArrayList<String>();
		while (i < length) {
//			list file 
			name =  UUID.randomUUID();
			extension = images[i++].split(";")[0].split("/")[1]; // png || jpeg.....
			base64 = images[i++];
			listFileName.add( name+"."+extension);
			FileCustom.saveFileBase64(pathBuild, name+"",extension, base64);
			FileCustom.saveFileBase64(pathproject, name+"",extension, base64);
		}
		return "add success";
	}
}
