package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.service.DiaChiService;

@Controller
public class DiaChiController {
	
	@Autowired
	private DiaChiService diaChiService;
	
//	@ResponseBody
//	@RequestMapping(value = "/dia-chi/danh-sach-dia-chi", method = RequestMethod.GET )
	@RequestMapping("/dia-chi/danh-sach-dia-chi")
	public  void   danhSachDiaChiAjax() {
		
		System.out.println(diaChiService.getDanhSachTinhThanhPho());
		
	}

}
