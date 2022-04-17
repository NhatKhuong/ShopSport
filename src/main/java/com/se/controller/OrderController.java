package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

	@GetMapping("/don-hang/tao-don-hang")
	public String taoDonHang(Model model) {
		
		
		List<String[]> listPreadcrumb = new ArrayList<String[]>();
//		 String[0] =  name page 
//		 String[1] =  href page 
		listPreadcrumb.add(new String[] {"Home", ""});
		listPreadcrumb.add(new String[] {"Đơn hàng", "/don-hang"});
		listPreadcrumb.add(new String[] {"Mua hàng", ""});
		
		
		model.addAttribute("listPreadcrumb", listPreadcrumb);
		return "createOrder";
	}
}
