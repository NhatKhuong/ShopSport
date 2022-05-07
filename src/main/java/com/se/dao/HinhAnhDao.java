package com.se.dao;

import java.util.List;

import com.se.entity.HinhAnhSanPham;


public interface HinhAnhDao {
	public  boolean themHinhAnhSanPham(HinhAnhSanPham hinhAnhSanPham);
	public  boolean xoaHinhAnhSanPham(String maHinhAnh);
	public String getId();
}
