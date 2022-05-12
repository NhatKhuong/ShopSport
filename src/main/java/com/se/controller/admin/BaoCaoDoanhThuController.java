package com.se.controller.admin;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.entity.SanPham;
import com.se.service.ThongKeDonHangService;


@Controller
public class BaoCaoDoanhThuController {
//	@RequestMapping("/quan-ly/bao-cao-doanh-thu")
//	public String showQuanLyDonHang() {
//		return "admin/baoCaoDoanhThu";
//	}
	
	@Autowired
	private ThongKeDonHangService thongKeDonHangService;

	@RequestMapping("/quan-ly/bao-cao-doanh-thu")
	public String showQuanLyDonHang(Model model) {
		Date ngayHienTai = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayMacDinh = new Date(99, 00, 01);
		String ngayHienTaiStr = format.format(ngayHienTai).toString();
		String ngayMacDinhStr = format.format(ngayMacDinh).toString();
		int soLuongNguoiDung = thongKeDonHangService.getCountAll();
		int soDonHang = thongKeDonHangService.soDonHangTrongKhoangNgay(ngayMacDinhStr,ngayHienTaiStr);
		model.addAttribute("soLuongNguoiDung", soLuongNguoiDung);
		model.addAttribute("soDonHang", soDonHang);
		int soLuongSanPham = thongKeDonHangService.CountAllSP();
		model.addAttribute("soLuongSanPham", soLuongSanPham);
		int soDonThanhCong = thongKeDonHangService.soDonHangThanhCong(ngayMacDinhStr,ngayHienTaiStr);
		model.addAttribute("soDonThanhCong", soDonThanhCong);
		double tienThuNhap = Math.round(thongKeDonHangService.soTienThuNhap(ngayMacDinhStr, ngayHienTaiStr));
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		model.addAttribute("tienThuNhap", decimalFormat.format(tienThuNhap));
		int soSPHetHang = thongKeDonHangService.CountSPHetHang();
		model.addAttribute("soSPHetHang", soSPHetHang);
		int soDonHangChoXacNhan = thongKeDonHangService.CountDonHangChoXacNhan(ngayMacDinhStr,ngayHienTaiStr);
		int soDonHangHuy = thongKeDonHangService.CountDonHangHuy(ngayMacDinhStr,ngayHienTaiStr);
		int soNguoiDungBiChan = thongKeDonHangService.CountNguoiDungBiChan();
		model.addAttribute("soDonHangChoXacNhan", soDonHangChoXacNhan);
		model.addAttribute("soDonHangHuy", soDonHangHuy);
		model.addAttribute("soNguoiDungBiChan", soNguoiDungBiChan);
		List<SanPham> listSanPhamBanChay = thongKeDonHangService.listSanPhamBanChay(ngayMacDinhStr,ngayHienTaiStr);
		model.addAttribute("listSanPhamBanChay", listSanPhamBanChay);

		List<?> listDonHangBan = thongKeDonHangService.listHoaDonBan(ngayMacDinhStr,ngayHienTaiStr);
		model.addAttribute("listDonHangBan", listDonHangBan);
		List<?> listsanPhamHetHang = thongKeDonHangService.listSanPhamHetHang();
		model.addAttribute("listsanPhamHetHang", listsanPhamHetHang);
		List<?> listThongKe = thongKeDonHangService.listThongKe();
		model.addAttribute("listThongKe", listThongKe);
		return "admin/baoCaoDoanhThu";
	}

}

