package com.se.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.se.entity.NguoiDung;
import com.se.service.NguoiDungService;

public class User {
	@Autowired
	private static NguoiDungService nguoiDungService;
	public static String getEmailNguoiDung() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		
		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		return email;
	}

}
