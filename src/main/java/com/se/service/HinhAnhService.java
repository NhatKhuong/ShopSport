package com.se.service;

import com.se.entity.HinhAnhSanPham;

public interface HinhAnhService {
	public  boolean themHinhAnhSanPham(HinhAnhSanPham hinhAnhSanPham);
	public  boolean xoaHinhAnhSanPham(String maHinhAnh);
	public String getId();
}
